package com.mij.itembox.ui.auth

import MedievalTextField
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.mij.itembox.ui.page.composables.AppBackground
import com.mij.itembox.viewmodel.AuthViewModel

@Composable
fun LoginScreen(navController: NavController, viewModel: AuthViewModel = viewModel()) {

    val mensaje by viewModel.mensaje.collectAsState()
    val isLogged by viewModel.isLogged.collectAsState()

    var email by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

    // Si login correcto → ir al main
    if (isLogged) {
        navController.navigate("main") {
            popUpTo("login") { inclusive = true }
        }
    }

    AppBackground {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                "Iniciar Sesión",
                style = MaterialTheme.typography.headlineSmall,
                color = Color(0xFFE6D5A4) // dorado medieval
            )

            Spacer(Modifier.height(20.dp))

            // EMAIL
            MedievalTextField(
                value = email,
                onValueChange = { email = it },
                label = "Email"
            )

            Spacer(Modifier.height(12.dp))

            // PASSWORD
            MedievalTextField(
                value = pass,
                onValueChange = { pass = it },
                label = "Contraseña",
                isPassword = true
            )

            Spacer(Modifier.height(20.dp))

            // BOTÓN LOGIN
            Button(
                onClick = { viewModel.login(email, pass) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE6D5A4),
                    contentColor = Color(0xFF2C1B14)
                )
            ) {
                Text("Entrar")
            }

            Spacer(Modifier.height(10.dp))

            // IR A REGISTRO
            TextButton(onClick = { navController.navigate("register") }) {
                Text(
                    "¿No tienes cuenta? Crear cuenta",
                    color = Color(0xFFD3C29E)
                )
            }

            if (mensaje.isNotEmpty()) {
                Spacer(Modifier.height(8.dp))
                Text(mensaje, color = Color.Red)
            }
        }
    }
}
