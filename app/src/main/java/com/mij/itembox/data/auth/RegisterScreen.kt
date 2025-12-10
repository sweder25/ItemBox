import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mij.itembox.ui.page.composables.AppBackground
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mij.itembox.viewmodel.AuthViewModel

@Composable
fun RegisterScreen(navController: NavController, viewModel: AuthViewModel = viewModel()) {

    val mensaje by viewModel.mensaje.collectAsState()

    var nombre by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

    AppBackground {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                "Crear Cuenta",
                style = MaterialTheme.typography.headlineSmall,
                color = Color(0xFFE6D5A4)
            )

            Spacer(Modifier.height(20.dp))

            MedievalTextField(value = nombre, onValueChange = { nombre = it }, label = "Nombre")
            Spacer(Modifier.height(12.dp))

            MedievalTextField(value = email, onValueChange = { email = it }, label = "Email")
            Spacer(Modifier.height(12.dp))

            MedievalTextField(value = pass, onValueChange = { pass = it }, label = "Contraseña", isPassword = true)
            Spacer(Modifier.height(20.dp))

            Button(
                onClick = { viewModel.register(nombre, email, pass) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE6D5A4),
                    contentColor = Color(0xFF2C1B14)
                )
            ) {
                Text("Registrar")
            }

            Spacer(Modifier.height(10.dp))

            TextButton(onClick = { navController.navigate("login") }) {
                Text("Volver al inicio", color = Color(0xFFD3C29E))
            }

            if (mensaje.isNotEmpty()) {
                Spacer(Modifier.height(8.dp))
                Text(mensaje, color = Color.Red)
            }
        }
    }
}
