package com.mij.itembox.ui.page.formularios

import com.mij.itembox.data.model.productos.Vegetal
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
import com.mij.itembox.ui.page.composables.DropdownSelector
import com.mij.itembox.ui.page.composables.StyledTextField
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
import com.mij.itembox.data.Rareza
import com.mij.itembox.data.Resistencia
import com.mij.itembox.data.viewmodel.productos.VegetalViewModel
import com.mij.itembox.ui.page.composables.AppBackground

@Composable
fun FormularioVegetal(
    idProducto: Long,
    viewModel: VegetalViewModel,
    rarezas: List<Rareza>,
    resistencias: List<Resistencia>,
    onFinalizar: () -> Unit
) {
    var rarezaSeleccionada by remember { mutableStateOf<Rareza?>(null) }
    var resistenciaFrio by remember { mutableStateOf<Resistencia?>(null) }
    var resistenciaCalor by remember { mutableStateOf<Resistencia?>(null) }
    var resistenciaHumedad by remember { mutableStateOf<Resistencia?>(null) }
    var resistenciaSequia by remember { mutableStateOf<Resistencia?>(null) }
    var resistenciaLuz by remember { mutableStateOf<Resistencia?>(null) }

    var descripcion by remember { mutableStateOf("") }
    var propiedades by remember { mutableStateOf("") }
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
                        "Paso 2: Datos de Vegetal",
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

                    // ---------- RESISTENCIAS ----------
                    DropdownSelector(
                        label = "Resistencia al frío",
                        items = resistencias,
                        selectedItem = resistenciaFrio,
                        itemText = { it.descripcion },
                        onItemSelected = { resistenciaFrio = it }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    DropdownSelector(
                        label = "Resistencia al calor",
                        items = resistencias,
                        selectedItem = resistenciaCalor,
                        itemText = { it.descripcion },
                        onItemSelected = { resistenciaCalor = it }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    DropdownSelector(
                        label = "Resistencia a la humedad",
                        items = resistencias,
                        selectedItem = resistenciaHumedad,
                        itemText = { it.descripcion },
                        onItemSelected = { resistenciaHumedad = it }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    DropdownSelector(
                        label = "Resistencia a la sequía",
                        items = resistencias,
                        selectedItem = resistenciaSequia,
                        itemText = { it.descripcion },
                        onItemSelected = { resistenciaSequia = it }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    DropdownSelector(
                        label = "Resistencia a la luz",
                        items = resistencias,
                        selectedItem = resistenciaLuz,
                        itemText = { it.descripcion },
                        onItemSelected = { resistenciaLuz = it }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // ---------- DESCRIPCIÓN ----------
                    StyledTextField(
                        value = descripcion,
                        label = "Descripción",
                        onValueChange = { descripcion = it }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // ---------- PROPIEDADES ----------
                    StyledTextField(
                        value = propiedades,
                        label = "Propiedades",
                        onValueChange = { propiedades = it }
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

                    // ---------- BOTÓN ----------
                    Button(
                        onClick = {
                            val magiaVal = magia.toIntOrNull()
                            val pesoVal = peso.toDoubleOrNull()

                            if (
                                rarezaSeleccionada == null ||
                                resistenciaFrio == null ||
                                resistenciaCalor == null ||
                                resistenciaHumedad == null ||
                                resistenciaSequia == null ||
                                resistenciaLuz == null ||
                                descripcion.isBlank() ||
                                propiedades.isBlank() ||
                                magiaVal == null ||
                                pesoVal == null
                            ) {
                                error = "Completa todos los campos correctamente"
                            } else {
                                error = null

                                viewModel.insert(
                                    Vegetal(
                                        id_producto = idProducto,
                                        rareza = rarezaSeleccionada!!.id,
                                        resistencia_frio = resistenciaFrio!!.id,
                                        resistencia_calor = resistenciaCalor!!.id,
                                        resistencia_humedad = resistenciaHumedad!!.id,
                                        resistencia_sequia = resistenciaSequia!!.id,
                                        resistencia_luz = resistenciaLuz!!.id,
                                        descripcion = descripcion.trim(),
                                        propiedades = propiedades.trim(),
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
