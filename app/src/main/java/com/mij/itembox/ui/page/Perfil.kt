
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import com.mij.itembox.data.dataclass.ProductoConCantidad
import com.mij.itembox.data.viewmodel.InventarioViewModel
import com.mij.itembox.ui.page.composables.AppBackground

@Composable
fun PerfilPage(
    inventarioViewModel: InventarioViewModel,
    onIrAComprar: (Long?) -> Unit
) {
    val inventarios by inventarioViewModel.allItems.collectAsState(initial = emptyList())
    var inventarioSeleccionado by remember { mutableStateOf<Long?>(null) }
    var productos by remember { mutableStateOf<List<ProductoConCantidad>>(emptyList()) }
    var inventarioActivo by remember { mutableStateOf<Long?>(null) }

    AppBackground {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Text(
                "Tus Inventarios",
                style = MaterialTheme.typography.headlineSmall,
                color = Color(0xFFE6D5A4) // dorado medieval
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Lista de inventarios
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
                                        inventarioViewModel.getProductosConCantidad(
                                            inventario.id_inventario
                                        ) { productos = it }
                                    }
                                },
                                onDoubleTap = {
                                    if (inventarioActivo == inventario.id_inventario) {
                                        inventarioActivo = null
                                    } else {
                                        inventarioActivo = inventario.id_inventario
                                        inventarioSeleccionado = inventario.id_inventario

                                        inventarioViewModel.getProductosConCantidad(
                                            inventario.id_inventario
                                        ) { productos = it }
                                    }
                                }
                            )
                        },
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF2C1B14) // madera oscura estilo medieval
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            "Nombre: ${inventario.nombre}",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color(0xFFE6D5A4)
                        )
                        Text(
                            "Dinero: ${inventario.dinero}",
                            color = Color(0xFFD3C29E)
                        )
                    }
                }
            }

            inventarioSeleccionado?.let { id ->
                val inventario = inventarios.find { it.id_inventario == id }
                inventario?.let {
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        "Productos en inventario: ${it.nombre}",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color(0xFFE6D5A4)
                    )

                    productos.forEach { producto ->
                        Text(
                            "- ${producto.nombre}: ${producto.cantidad}",
                            color = Color(0xFFD3C29E)
                        )
                    }
                }
            }

            inventarioActivo?.let { id ->
                val inventario = inventarios.find { it.id_inventario == id }
                inventario?.let {
                    Spacer(modifier = Modifier.height(24.dp))
                    Divider(color = Color(0x66FFFFFF))
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        "Inventario activo para operaciones: ${it.nombre}",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color(0xFFE6D5A4)
                    )

                    Text(
                        "Dinero disponible: ${it.dinero}",
                        color = Color(0xFFD3C29E)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { onIrAComprar(inventarioActivo) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ir a comprar")
            }
        }
    }
}

