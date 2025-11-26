package com.mij.itembox.ui.page.formularios

import com.mij.itembox.data.model.productos.Vegetal
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.mij.itembox.data.predeterminados.DropdownSelector
import com.mij.itembox.data.predeterminados.Rareza
import com.mij.itembox.data.predeterminados.Resistencia
import com.mij.itembox.data.viewmodel.productos.VegetalViewModel

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

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Paso 2: Datos de Vegetal", style = MaterialTheme.typography.headlineSmall)

        DropdownSelector("Rareza", rarezas, rarezaSeleccionada, { it.descripcion }) { rarezaSeleccionada = it }
        DropdownSelector("Resistencia al frío", resistencias, resistenciaFrio, { it.descripcion }) { resistenciaFrio = it }
        DropdownSelector("Resistencia al calor", resistencias, resistenciaCalor, { it.descripcion }) { resistenciaCalor = it }
        DropdownSelector("Resistencia a la humedad", resistencias, resistenciaHumedad, { it.descripcion }) { resistenciaHumedad = it }
        DropdownSelector("Resistencia a la sequía", resistencias, resistenciaSequia, { it.descripcion }) { resistenciaSequia = it }
        DropdownSelector("Resistencia a la luz", resistencias, resistenciaLuz, { it.descripcion }) { resistenciaLuz = it }

        OutlinedTextField(
            value = descripcion,
            onValueChange = { descripcion = it },
            label = { Text("Descripción") }
        )

        OutlinedTextField(
            value = propiedades,
            onValueChange = { propiedades = it },
            label = { Text("Propiedades") }
        )

        OutlinedTextField(
            value = magia,
            onValueChange = { magia = it },
            label = { Text("Magia") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        OutlinedTextField(
            value = peso,
            onValueChange = { peso = it },
            label = { Text("Peso") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        if (error != null) {
            Text(text = error!!, color = MaterialTheme.colorScheme.error)
        }

        Button(onClick = {
            val magiaVal = magia.toIntOrNull()
            val pesoVal = peso.toDoubleOrNull()
            if (
                rarezaSeleccionada == null || resistenciaFrio == null || resistenciaCalor == null ||
                resistenciaHumedad == null || resistenciaSequia == null || resistenciaLuz == null ||
                descripcion.isBlank() || propiedades.isBlank() || magiaVal == null || pesoVal == null
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
        }) {
            Text("Finalizar")
        }
    }
}