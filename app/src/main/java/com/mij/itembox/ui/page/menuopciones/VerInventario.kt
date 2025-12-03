package com.mij.itembox.ui.page.menuopciones

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mij.itembox.data.viewmodel.InventarioViewModel
import com.mij.itembox.ui.page.composables.AppBackground

@Composable
fun VerInventarioPage(
    inventarioViewModel: InventarioViewModel,
    onSeleccionar: (Long) -> Unit
) {
    val inventarios by inventarioViewModel.allItems.collectAsState(initial = emptyList())

    AppBackground {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Text(
                "Inventarios existentes",
                style = MaterialTheme.typography.headlineSmall,
                color = Color(0xFFE6D5A4) // mismo dorado de PerfilPage
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Lista de inventarios con estilo de PerfilPage
            inventarios.forEach { inventario ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable { onSeleccionar(inventario.id_inventario) },
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF2C1B14) // madera oscura medieval
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            "Nombre: ${inventario.nombre}",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color(0xFFE6D5A4) // dorado medieval
                        )

                        Text(
                            "Dinero: ${inventario.dinero}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(0xFFD3C29E) // beige suave medieval
                        )
                    }
                }
            }
        }
    }
}

