package com.mij.itembox.ui.page.menuopciones

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.graphics.Color
import com.mij.itembox.data.model.Producto
import com.mij.itembox.data.viewmodel.ProductoViewModel
import com.mij.itembox.ui.page.composables.AppBackground
import com.mij.itembox.util.saveImageToInternalStorage
import kotlinx.coroutines.launch
import androidx.compose.material3.TextFieldDefaults


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
                val path = saveImageToInternalStorage(
                    context,
                    uri,
                    "producto_${System.currentTimeMillis()}"
                )
                imagenPath = path
            }
        }
    }

    val tiposDisponibles = listOf(
        "Animal", "Elaborado", "Mineral", "ProductoAnimal", "Vegetal"
    )


    //     FONDO PERSONALIZADO
    AppBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            //   CARD CLARA Y VISUAL
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xAA1A1A1A) // gris oscuro translúcido
                ),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {

                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        "Paso 1: Crear Producto",
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color(0xFFE6D5A4)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = nombre,
                        onValueChange = { nombre = it },
                        label = { Text("Nombre",color = Color (0xFFE6D5A4)) },
                        colors = TextFieldDefaults.colors(
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            cursorColor = Color.White,
                            focusedIndicatorColor = Color.White,
                            unfocusedIndicatorColor = Color.Gray,
                            focusedLabelColor = Color.White,
                            unfocusedLabelColor = Color.LightGray,
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            errorContainerColor = Color.Transparent
                        )
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = precioTexto,
                        onValueChange = { precioTexto = it },
                        label = { Text("Precio", color = Color(0xFFE6D5A4)) },
                        colors = TextFieldDefaults.colors(
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            cursorColor = Color.White,
                            focusedIndicatorColor = Color.White,
                            unfocusedIndicatorColor = Color.Gray,
                            focusedLabelColor = Color.White,
                            unfocusedLabelColor = Color.LightGray,
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            errorContainerColor = Color.Transparent
                        ),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    //  DROPDOWN VISUAL Y CLARO
                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = { expanded = !expanded }
                    ) {
                        OutlinedTextField(
                            value = tipoSeleccionado,
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("Tipo", color = Color(0xFFE6D5A4)) },
                            textStyle = LocalTextStyle.current.copy(color = Color(0xFFE6D5A4)),
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
                            modifier = Modifier
                                .menuAnchor()
                                .fillMaxWidth(),
                        )

                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            tiposDisponibles.forEach { tipo ->
                                DropdownMenuItem(
                                    text = { Text(tipo, color = Color.Black) },
                                    onClick = {
                                        tipoSeleccionado = tipo
                                        expanded = false
                                    }
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    if (error != null) {
                        Text(
                            text = error!!,
                            color = MaterialTheme.colorScheme.error
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                    }

                    Button(
                        onClick = { launcher.launch("image/*") },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFE6D5A4),
                            contentColor = Color.Black
                        )
                    ) {
                        Text("Seleccionar imagen")
                    }

                    if (imagenPath != null) {
                        Text(
                            "Imagen seleccionada",
                            color = Color(0xFFE6D5A4),
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {
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
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFE6D5A4),
                            contentColor = Color.Black
                        )
                    ) {
                        Text("Continuar")
                    }
                }
            }
        }
    }
}
