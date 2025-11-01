import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun CrearProducto(modifier: Modifier = Modifier){

    // Estado para el texto ingresado
    var nombre by remember { mutableStateOf("") }

    // Estado para mostrar el resultado
    var resultText by remember { mutableStateOf("") }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = "Creación de Producto")


            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Ingresa el Nombre") }
            )

            // Botón que usa el texto ingresado
            Button(onClick = {
                resultText = "Ingresaste: $inputText"
            }) {
                Text("Mostrar texto")
            }

            // Botón para limpiar
            Button(onClick = {
                inputText = ""
                resultText = ""
            }) {
                Text("Limpiar")
            }

            // Mostrar resultado si hay texto
            if (resultText.isNotEmpty()) {
                Text(text = resultText)
            }
        }

    }
}