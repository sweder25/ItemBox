package com.mij.itembox.ui.page.formularios

import com.mij.itembox.data.model.productos.Mineral
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.mij.itembox.ui.page.composables.DropdownSelector
import com.mij.itembox.ui.page.composables.StyledTextField
import com.mij.itembox.data.Rareza
import com.mij.itembox.data.viewmodel.productos.MineralViewModel
import com.mij.itembox.ui.page.composables.AppBackground

@Composable
fun FormularioMineral(
    idProducto: Long,
    viewModel: MineralViewModel,
    rarezas: List<Rareza>,
    onFinalizar: () -> Unit
) {
    var rarezaSeleccionada by remember { mutableStateOf<Rareza?>(null) }
    var magia by remember { mutableStateOf("") }
    var descripcionObjeto by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }

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
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xAA1A1A1A)
                ),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {

                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        "Paso 2: Datos de Mineral",
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color(0xFFE6D5A4)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // ---------- RAREZA ----------
                    DropdownSelector(
                        label = "Rareza",
                        items = rarezas,
                        selectedItem = rarezaSeleccionada,
                        itemText = { it.descripcion },
                        onItemSelected = { rarezaSeleccionada = it }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // ---------- MAGIA ----------
                    StyledTextField(
                        value = magia,
                        label = "Magia",
                        onValueChange = { magia = it },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // ---------- DESCRIPCIÓN OBJETO ----------
                    StyledTextField(
                        value = descripcionObjeto,
                        label = "Descripción del objeto",
                        onValueChange = { descripcionObjeto = it }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // ---------- PESO ----------
                    StyledTextField(
                        value = peso,
                        label = "Peso",
                        onValueChange = { peso = it },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    if (error != null) {
                        Text(
                            error!!,
                            color = MaterialTheme.colorScheme.error,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {
                            val magiaVal = magia.toIntOrNull()
                            val pesoVal = peso.toDoubleOrNull()

                            if (
                                rarezaSeleccionada == null ||
                                magiaVal == null ||
                                descripcionObjeto.isBlank() ||
                                pesoVal == null
                            ) {
                                error = "Completa todos los campos correctamente"
                            } else {
                                error = null

                                viewModel.insert(
                                    Mineral(
                                        id_producto = idProducto,
                                        rareza = rarezaSeleccionada!!.id,
                                        magia = magiaVal,
                                        descripcion_objeto = descripcionObjeto.trim(),
                                        peso = pesoVal
                                    )
                                )

                                onFinalizar()
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Gray,
                            contentColor = Color.Black
                        )
                    ) {
                        Text("Finalizar")
                    }
                }
            }
        }
    }
}
