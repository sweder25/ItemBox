import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mij.itembox.ui.page.composables.AppBackground


@Composable
fun MenuDropdown(navController: NavController, modifier: Modifier = Modifier) {

    AppBackground {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Menu de Gestión",
                color = Color(0xFFE6D5A4) // dorado viejo medieval
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = { navController.navigate("CrearProducto") }) {
                Text("Crear un Producto")
            }

            Button(onClick = { navController.navigate("VerProductos") }) {
                Text("Ver los Productos")
            }

            Button(onClick = { navController.navigate("CrearInventario") }) {
                Text("Crear un Inventario")
            }

            Button(onClick = { navController.navigate("VerInventarios") }) {
                Text("Ver los Inventarios")
            }
        }
    }
}
