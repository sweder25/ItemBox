package com.mij.itembox.ui.page.menuopciones

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.mij.itembox.data.viewmodel.ProductoViewModel
import com.mij.itembox.data.viewmodel.productos.AnimalViewModel
import com.mij.itembox.data.viewmodel.productos.ElaboradoViewModel
import com.mij.itembox.data.viewmodel.productos.MineralViewModel
import com.mij.itembox.data.viewmodel.productos.ProductoAnimalViewModel
import com.mij.itembox.data.viewmodel.productos.VegetalViewModel
import com.mij.itembox.ui.page.composables.ProductoConDetalles




@Composable
fun VerProductos(
    productoViewModel: ProductoViewModel,
    animalViewModel: AnimalViewModel,
    vegetalViewModel: VegetalViewModel,
    mineralViewModel: MineralViewModel,
    elaboradoViewModel: ElaboradoViewModel,
    productoAnimalViewModel: ProductoAnimalViewModel
) {
    val productos by productoViewModel.allProducto.collectAsState(initial = emptyList())
    var filtroId by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = filtroId,
            onValueChange = { filtroId = it },
            label = { Text("Buscar por ID") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        val idFiltrado = filtroId.toLongOrNull()
        val productosFiltrados = if (idFiltrado != null) {
            productos.filter { it.id_producto == idFiltrado }
        } else {
            productos
        }

        LazyColumn {
            items(productosFiltrados) { producto ->
                ProductoConDetalles(
                    producto = producto,
                    animalViewModel = animalViewModel,
                    vegetalViewModel = vegetalViewModel,
                    mineralViewModel = mineralViewModel,
                    elaboradoViewModel = elaboradoViewModel,
                    productoAnimalViewModel = productoAnimalViewModel
                )
            }
        }
    }
}

