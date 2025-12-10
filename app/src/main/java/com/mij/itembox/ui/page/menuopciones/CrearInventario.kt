package com.mij.itembox.ui.page.menuopciones

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.mij.itembox.data.model.Inventario
import com.mij.itembox.data.viewmodel.InventarioViewModel
import com.mij.itembox.ui.page.composables.AppBackground


@Composable
fun CrearInventarioPage(
    inventarioViewModel: InventarioViewModel,
    onInventarioCreado: () -> Unit
) {
    var nombre by remember { mutableStateOf("") }
    var dinero by remember { mutableStateOf("") }

    AppBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xAA1C1C1C)
                ),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        "Crear nuevo inventario",
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color(0xFFE6D5A4)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = nombre,
                        onValueChange = { nombre = it },
                        label = { Text("Nombre del inventario", color = Color(0xFFE6D5A4)) },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = dinero,
                        onValueChange = { dinero = it },
                        label = { Text("Dinero inicial", color = Color(0xFFE6D5A4)) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {
                            val monto = dinero.toDoubleOrNull() ?: 0.0
                            if (nombre.isNotBlank()) {
                                val nuevoInventario = Inventario(nombre = nombre, dinero = monto)
                                inventarioViewModel.insert(nuevoInventario)
                                onInventarioCreado()
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFE6D5A4),
                            contentColor = Color.Black
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Guardar inventario")
                    }
                }
            }
        }
    }
}
