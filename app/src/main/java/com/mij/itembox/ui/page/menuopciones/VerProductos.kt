package com.mij.itembox.ui.page.menuopciones

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.mij.itembox.data.viewmodel.ProductoViewModel
import com.mij.itembox.data.viewmodel.productos.*
import com.mij.itembox.ui.page.composables.AppBackground
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

    AppBackground {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Text(
                "Listado de Productos",
                style = MaterialTheme.typography.headlineSmall,
                color = Color(0xFFE6D5A4) // dorado medieval
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Campo de búsqueda medieval
            OutlinedTextField(
                value = filtroId,
                onValueChange = { filtroId = it },
                label = {
                    Text(
                        text = "Buscar por ID",
                        color = Color(0xFFE6D5A4)
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFFE6D5A4),
                    unfocusedBorderColor = Color(0xFFD3C29E),
                    focusedLabelColor = Color(0xFFE6D5A4),
                    unfocusedLabelColor = Color(0xFFD3C29E),
                    cursorColor = Color(0xFFE6D5A4),
                    focusedTextColor = Color(0xFFE6D5A4),
                    unfocusedTextColor = Color(0xFFD3C29E)
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            val idFiltrado = filtroId.toLongOrNull()
            val productosFiltrados = if (idFiltrado != null) {
                productos.filter { it.id_producto == idFiltrado }
            } else productos

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
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
}
