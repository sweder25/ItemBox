package com.mij.itembox.ui.page.formularios

import com.mij.itembox.data.model.productos.Elaborado
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
import com.mij.itembox.data.DropdownSelector
import com.mij.itembox.data.Rareza
import com.mij.itembox.data.viewmodel.productos.ElaboradoViewModel

@Composable
fun FormularioElaborado(
    idProducto: Long,
    viewModel: ElaboradoViewModel,
    rarezas: List<Rareza>,
    onFinalizar: () -> Unit
) {
    var rarezaSeleccionada by remember { mutableStateOf<Rareza?>(null) }
    var magia by remember { mutableStateOf("") }
    var descripcionObjeto by remember { mutableStateOf("") }
    var descripcionPropiedades by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Paso 2: Datos de Elaborado", style = MaterialTheme.typography.headlineSmall)

        DropdownSelector("Rareza", rarezas, rarezaSeleccionada, { it.descripcion }) { rarezaSeleccionada = it }

        OutlinedTextField(
            value = magia,
            onValueChange = { magia = it },
            label = { Text("Magia") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        OutlinedTextField(
            value = descripcionObjeto,
            onValueChange = { descripcionObjeto = it },
            label = { Text("Descripción del objeto") }
        )

        OutlinedTextField(
            value = descripcionPropiedades,
            onValueChange = { descripcionPropiedades = it },
            label = { Text("Propiedades") }
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
                rarezaSeleccionada == null || magiaVal == null ||
                descripcionObjeto.isBlank() || descripcionPropiedades.isBlank() || pesoVal == null
            ) {
                error = "Completa todos los campos correctamente"
            } else {
                error = null
                viewModel.insert(
                    Elaborado(
                        id_producto = idProducto,
                        rareza = rarezaSeleccionada!!.id,
                        magia = magiaVal,
                        descripcion_objeto = descripcionObjeto.trim(),
                        descripcion_propiedades = descripcionPropiedades.trim(),
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