package com.mij.itembox.ui.page.formularios

import com.mij.itembox.data.model.productos.Animal
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import com.mij.itembox.data.DropdownSelector
import com.mij.itembox.data.Rareza
import com.mij.itembox.data.viewmodel.productos.AnimalViewModel
import com.mij.itembox.ui.page.composables.AppBackground
import com.mij.itembox.ui.page.composables.StyledTextField
import androidx.compose.material3.ButtonDefaults
import com.mij.itembox.ui.page.composables.DropdownSelector




@Composable
fun FormularioAnimal(
    idProducto: Long,
    viewModel: AnimalViewModel,
    rarezas: List<Rareza>,
    onFinalizar: () -> Unit
) {
    var rarezaSeleccionada by remember { mutableStateOf<Rareza?>(null) }
    var descripcionEspecie by remember { mutableStateOf("") }
    var magia by remember { mutableStateOf("") }
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
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xAA1A1A1A)
                ),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {

                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        "Paso 2: Datos de Animal",
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color(0xFFE6D5A4)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // ---------------------------
                    //       RAREZA DROPDOWN
                    // ---------------------------
                    DropdownSelector(
                        label = "Rareza",
                        items = rarezas,
                        selectedItem = rarezaSeleccionada,
                        itemText = { it.descripcion },
                        onItemSelected = { rarezaSeleccionada = it }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // ---------------------------
                    //   CAMPOS DE TEXTO ESTILO
                    // ---------------------------

                    StyledTextField(
                        value = descripcionEspecie,
                        label = "Descripción de la especie",
                        onValueChange = { descripcionEspecie = it }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    StyledTextField(
                        value = magia,
                        label = "Magia",
                        onValueChange = { magia = it },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

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
                                descripcionEspecie.isBlank() ||
                                magiaVal == null ||
                                pesoVal == null
                            ) {
                                error = "Completa todos los campos correctamente"
                            } else {
                                error = null

                                viewModel.insert(
                                    Animal(
                                        id_producto = idProducto,
                                        rareza = rarezaSeleccionada!!.id,
                                        descripcion_especie = descripcionEspecie.trim(),
                                        magia = magiaVal,
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

