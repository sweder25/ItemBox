package com.mij.itembox.ui.page


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.mij.itembox.data.dataclass.ProductoConCantidad
import com.mij.itembox.data.viewmodel.InventarioViewModel

@Composable
fun PerfilPage(inventarioViewModel: InventarioViewModel, onIrAComprar: (Long?) -> Unit) {
    val inventarios by inventarioViewModel.allItems.collectAsState(initial = emptyList())
    var inventarioSeleccionado by remember { mutableStateOf<Long?>(null) }
    var productos by remember { mutableStateOf<List<ProductoConCantidad>>(emptyList()) }
    var inventarioActivo by remember { mutableStateOf<Long?>(null) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Tus Inventarios", style = MaterialTheme.typography.headlineSmall)

        inventarios.forEach { inventario ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                        .pointerInput(inventario.id_inventario) {
                            detectTapGestures(
                                onTap = {
                                   
                                    if (inventarioSeleccionado == inventario.id_inventario) {
                                        inventarioSeleccionado = null
                                        productos = emptyList()
                                    } else {
                                        inventarioSeleccionado = inventario.id_inventario
                                        inventarioViewModel.getProductosConCantidad(inventario.id_inventario) {
                                            productos = it
                                        }
                                    }
                                },
                                onDoubleTap = {
                                   
                                    if (inventarioActivo == inventario.id_inventario) {
                                        inventarioActivo = null
                                    } else {
                                        inventarioActivo = inventario.id_inventario
                                     
                                        inventarioSeleccionado = inventario.id_inventario
                                        inventarioViewModel.getProductosConCantidad(inventario.id_inventario) {
                                            productos = it
                                        }
                                    }
                                }
                            )
                        }
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Nombre: ${inventario.nombre}", style = MaterialTheme.typography.titleMedium)
                    Text("Dinero: ${inventario.dinero}")
                }
            }
        }

        inventarioSeleccionado?.let { id ->
            val inventario = inventarios.find { it.id_inventario == id }
            inventario?.let {
                Spacer(modifier = Modifier.height(16.dp))
                Text("Productos en inventario: ${it.nombre}", style = MaterialTheme.typography.titleMedium)
                productos.forEach { producto ->
                    Text("- ${producto.nombre}: ${producto.cantidad}")
                }
            }
        }

        inventarioActivo?.let { id ->
            val inventario = inventarios.find { it.id_inventario == id }
            inventario?.let {
                Spacer(modifier = Modifier.height(24.dp))
                Divider()
                Spacer(modifier = Modifier.height(8.dp))
                Text("Inventario activo para operaciones: ${it.nombre}", style = MaterialTheme.typography.titleMedium)
                Text("Dinero disponible: ${it.dinero}")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onIrAComprar(inventarioActivo) }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Ir a comprar")
        }
    }
}
