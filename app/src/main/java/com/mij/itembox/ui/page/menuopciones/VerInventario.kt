package com.mij.itembox.ui.page.menuopciones

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mij.itembox.data.viewmodel.InventarioViewModel

@Composable
fun VerInventarioPage(inventarioViewModel: InventarioViewModel, onSeleccionar: (Long) -> Unit) {
    val inventarios by inventarioViewModel.allItems.collectAsState(initial = emptyList())

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Inventarios existentes", style = MaterialTheme.typography.headlineSmall)

        inventarios.forEach { inventario ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { onSeleccionar(inventario.id_inventario) }
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Nombre: ${inventario.nombre}", style = MaterialTheme.typography.titleMedium)
                    Text("Dinero: ${inventario.dinero}")
                }
            }
        }
    }
}