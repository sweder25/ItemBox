package com.mij.itembox.ui.page.menuopciones
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.mij.itembox.data.model.Producto
import com.mij.itembox.data.viewmodel.ProductoViewModel
import com.mij.itembox.util.saveImageToInternalStorage
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CrearProductoPaso1(
    viewModel: ProductoViewModel,
    onContinuar: (Long, String) -> Unit,
    modifier: Modifier = Modifier
) {
    var nombre by remember { mutableStateOf("") }
    var precioTexto by remember { mutableStateOf("") }
    var tipoSeleccionado by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf<String?>(null) }

    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var imagenPath by remember { mutableStateOf<String?>(null) }

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri?.let {
            scope.launch {
                val path = saveImageToInternalStorage(context, uri, "producto_${System.currentTimeMillis()}")
                imagenPath = path
            }
        }
    }



    val tiposDisponibles = listOf("Animal", "Elaborado", "Mineral", "ProductoAnimal", "Vegetal")

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(24.dp)
        ) {
            Text("Paso 1: Crear Producto", style = MaterialTheme.typography.headlineSmall)

            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") },
                singleLine = true
            )

            OutlinedTextField(
                value = precioTexto,
                onValueChange = { precioTexto = it },
                label = { Text("Precio") },
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                OutlinedTextField(
                    value = tipoSeleccionado,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Tipo") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
                    modifier = Modifier.menuAnchor()
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    tiposDisponibles.forEach { tipo ->
                        DropdownMenuItem(
                            text = { Text(tipo) },
                            onClick = {
                                tipoSeleccionado = tipo
                                expanded = false
                            }
                        )
                    }
                }
            }

            if (error != null) {
                Text(text = error!!, color = MaterialTheme.colorScheme.error)
            }

            Button(onClick = { launcher.launch("image/*") }) {
                Text("Seleccionar imagen")
            }

            if (imagenPath != null) {
                Text("Imagen seleccionada")
            }

            Button(onClick = {
                val precio = precioTexto.toDoubleOrNull()
                if (nombre.isBlank() || tipoSeleccionado.isBlank() || precio == null) {
                    error = "Completa todos los campos correctamente"
                } else {
                    error = null
                    val producto = Producto(
                        nombre = nombre.trim(),
                        tipo = tipoSeleccionado,
                        precio = precio,
                        imagenPath = imagenPath
                    )

                    viewModel.insertYRetornaId(producto) { id ->
                        onContinuar(id, tipoSeleccionado)
                    }
                }
            }) {
                Text("Continuar")
            }
        }
    }
}