package com.mij.itembox.ui.page.menuopciones

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.KeyboardType
import com.mij.itembox.data.AppDatabase
import com.mij.itembox.data.repository.InventarioRepository
import com.mij.itembox.data.repository.ProductoRepository
import com.mij.itembox.data.repository.StockRepository
import com.mij.itembox.data.viewmodel.Fabricadores.ProductoViewModelFabricador
import com.mij.itembox.data.viewmodel.ProductoViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch
import com.mij.itembox.network.BoletaApiClient
import com.mij.itembox.network.BoletaRequest

@Composable
fun TiendaPage(inventarioId: Long) {
    val context = LocalContext.current
    val factory = remember { ProductoViewModelFabricador(context.applicationContext as android.app.Application) }
    val productoViewModel: ProductoViewModel = viewModel(factory = factory)

    val productos by productoViewModel.allProducto.collectAsState(initial = emptyList())
    var filtro by remember { mutableStateOf("") }
    var mensaje by remember { mutableStateOf<String?>(null) }

    val database = remember { AppDatabase.getInstance(context) }
    val stockRepo = remember { StockRepository(database.stockDao()) }
    val inventarioRepo = remember { InventarioRepository(database.inventarioDao()) }
    val productoRepo = remember { ProductoRepository(database.productoDao()) }

    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = filtro,
            onValueChange = { filtro = it },
            label = { Text("Buscar por ID") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        mensaje?.let { msg ->
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = msg)
        }

        Spacer(modifier = Modifier.height(8.dp))

        val idFiltrado = filtro.toLongOrNull()
        val productosFiltrados = if (idFiltrado != null) productos.filter { it.id_producto == idFiltrado } else productos

        LazyColumn {
            items(productosFiltrados) { producto ->
                var cantidad by remember { mutableStateOf(0) }

                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(text = producto.nombre, style = MaterialTheme.typography.titleMedium)
                        Text(text = "Precio: ${producto.precio}")

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Row {
                                Button(onClick = { if (cantidad > 0) cantidad-- }) { Text("-") }
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(text = cantidad.toString(), modifier = Modifier.alignByBaseline())
                                Spacer(modifier = Modifier.width(8.dp))
                                Button(onClick = { cantidad++ }) { Text("+") }
                            }

                            Button(onClick = {
                                if (cantidad <= 0) {
                                    mensaje = "Selecciona una cantidad mayor que 0"
                                    return@Button
                                }

                                scope.launch {
                                    try {
                                        val inventario = inventarioRepo.getByIdSuspend(inventarioId)
                                        val total = producto.precio * cantidad
                                        if (inventario.dinero < total) {
                                            mensaje = "Dinero insuficiente"
                                            return@launch
                                        }

                                        
                                        stockRepo.agregarProductoAlInventario(inventarioId, producto.id_producto, cantidad)
                                        inventarioRepo.descontarDinero(inventarioId, total)
                                        // Compra realizada localmente; ahora intentar generar boleta en el microservicio
                                        mensaje = "Compra realizada: ${producto.nombre} x$cantidad"

                                        // Generar un ventaId temporal (placeholder). Reemplazar por el ID real de la entidad Venta si existe.
                                        val ventaId = System.currentTimeMillis()
                                        try {
                                            val resp = BoletaApiClient.api.generarBoleta(BoletaRequest(ventaId))
                                            if (resp.success == true) {
                                                val numero = resp.data?.numero ?: resp.data?.id
                                                mensaje = "Compra realizada: ${producto.nombre} x$cantidad. Boleta: $numero"
                                            } else {
                                                mensaje = "Compra realizada pero boleta falló: ${resp.message}"
                                            }
                                        } catch (e: Exception) {
                                            mensaje = "Compra realizada pero error al generar boleta: ${e.message}"
                                        }
                                        
                                        cantidad = 0
                                    } catch (e: Exception) {
                                        mensaje = "Error al realizar compra: ${e.message}"
                                    }
                                }
                            }) {
                                Text("Comprar")
                            }
                        }
                    }
                }
            }
        }
    }
}
