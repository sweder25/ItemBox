import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MenuDropdown(navController: NavController, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = "Menu de Gestión")

            Button(onClick = {
                navController.navigate("CrearProducto")
            }) {
                Text("Crear un Producto")
            }
            Button(onClick = {
                navController.navigate("VerProductos")
            }) {
                Text("Ver los Productos")
            }
            Button(onClick = {
                navController.navigate("CrearInventario")
            }) {
                Text("Crear un Inventario")
            }

            Button(onClick = {
                navController.navigate("VerInventarios")
            }) {
                Text("Ver los Inventarios")
            }


        }
    }
}


