package com.mij.itembox.ui.page.composables

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import com.mij.itembox.data.model.Producto
import com.mij.itembox.data.viewmodel.productos.AnimalViewModel
import com.mij.itembox.data.viewmodel.productos.ElaboradoViewModel
import com.mij.itembox.data.viewmodel.productos.MineralViewModel
import com.mij.itembox.data.viewmodel.productos.ProductoAnimalViewModel
import com.mij.itembox.data.viewmodel.productos.VegetalViewModel
import java.io.File

@Composable
fun ProductoConDetalles(
    producto: Producto,
    animalViewModel: AnimalViewModel,
    vegetalViewModel: VegetalViewModel,
    mineralViewModel: MineralViewModel,
    elaboradoViewModel: ElaboradoViewModel,
    productoAnimalViewModel: ProductoAnimalViewModel
) {
    var detalles by remember { mutableStateOf("Cargando...") }

    LaunchedEffect(producto.id_producto) {
        when (producto.tipo) {
            "Animal" -> animalViewModel.getById(producto.id_producto) {
                detalles = it?.descripcion_especie ?: "Sin datos"
            }
            "Vegetal" -> vegetalViewModel.getById(producto.id_producto) {
                detalles = it?.descripcion ?: "Sin datos"
            }
            "Mineral" -> mineralViewModel.getById(producto.id_producto) {
                detalles = it?.descripcion_objeto ?: "Sin datos"
            }
            "Elaborado" -> elaboradoViewModel.getById(producto.id_producto) {
                detalles = it?.descripcion_objeto ?: "Sin datos"
            }
            "ProductoAnimal" -> productoAnimalViewModel.getById(producto.id_producto) {
                detalles = it?.descripcion_propiedades ?: "Sin datos"
            }
        }
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            producto.imagenPath?.let { path ->
                val bitmap = remember(path) {
                    val file = File(path)
                    if (file.exists()) BitmapFactory.decodeFile(path) else null
                }
                bitmap?.let {
                    Image(
                        bitmap = it.asImageBitmap(),
                        contentDescription = "Imagen del producto",
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .width(80.dp)
                            .height(80.dp)
                    )
                }
            }

            Column {
                Text("Producto: ${producto.nombre}", style = MaterialTheme.typography.titleMedium)
                Text("Tipo: ${producto.tipo}")
                Text("Precio: ${producto.precio}")
                Text("Detalles: $detalles")
            }
        }
    }
}