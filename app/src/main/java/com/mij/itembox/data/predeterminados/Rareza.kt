package com.mij.itembox.data.predeterminados

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

data class Rareza(val id: Int, val descripcion: String)

val rarezasPredefinidas = listOf(
    Rareza(1, "Mitica"),
    Rareza(2, "Legendaria"),
    Rareza(3, "Muy Rara"),
    Rareza(4, "Rara"),
    Rareza(5, "Especial"),
    Rareza(6, "Comun"),
    Rareza(7, "Demasiado Frecuente")
)

@Composable
fun <T> DropdownSelector(
    label: String,
    opciones: List<T>,
    seleccion: T?,
    textoOpcion: (T) -> String,
    onSeleccionar: (T) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        OutlinedTextField(
            value = seleccion?.let(textoOpcion) ?: "",
            onValueChange = {},
            label = { Text(label) },
            readOnly = true,
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                }
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            opciones.forEach { opcion ->
                DropdownMenuItem(
                    text = { Text(textoOpcion(opcion)) },
                    onClick = {
                        onSeleccionar(opcion)
                        expanded = false
                    }
                )
            }
        }
    }
}