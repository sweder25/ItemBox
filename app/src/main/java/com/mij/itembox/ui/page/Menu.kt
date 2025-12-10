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
import androidx.compose.material3.*
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MenuDropdown(
    navController: NavController, // ESTE debe ser el PRINCIPAL
    modifier: Modifier = Modifier,
    viewModel: AuthViewModel = viewModel()
) {

    AppBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                "Menu de Gestión",
                color = Color(0xFFE6D5A4),
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(Modifier.height(24.dp))

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

            Spacer(Modifier.height(50.dp))

            Divider(color = Color(0xFFD3C29E))

            Spacer(Modifier.height(20.dp))

            // ---------------- CERRAR SESIÓN ----------------
            Button(
                onClick = {
                    viewModel.logout()
                    navController.navigate("login") {
                        popUpTo(0) { inclusive = true }   // <- Mata TODA la pila
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF8B0000),
                    contentColor = Color.White
                )
            ) {
                Text("Cerrar Sesión")
            }
        }
    }
}

