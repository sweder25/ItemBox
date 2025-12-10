import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.navigation.NavController
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight




@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar(
        containerColor = Color(0xFF1A0E0A), // cuero oscuro
        tonalElevation = 8.dp
    )
    {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
            label = {                     Text(
                "Inicio",
                color = Color(0xFFBFA58A), // dorado viejo medieval
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp
            ) },
            selected = false,
            onClick = { navController.navigate("home") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Yellow,
                selectedTextColor = Color.Yellow,
                indicatorColor = Color.Red,
                unselectedIconColor = Color.Gray,
                unselectedTextColor = Color.Gray,
            )
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
            label = { Text(
                "Perfil",
                color = Color(0xFFBFA58A), // dorado viejo medieval
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp
            ) },
            selected = false,
            onClick = { navController.navigate("perfil") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Yellow,
                selectedTextColor = Color.Yellow,
                indicatorColor = Color.Red,
                unselectedIconColor = Color.Gray,
                unselectedTextColor = Color.Gray,
            )
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Settings, contentDescription = "Ajustes") },
            label = {Text(
                "Ajustes",
                color = Color(0xFFBFA58A), // dorado viejo medieval
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp
            ) },
            selected = false,
            onClick = { navController.navigate("ajustes") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Yellow,
                selectedTextColor = Color.Yellow,
                indicatorColor = Color.Red,
                unselectedIconColor = Color.Gray,
                unselectedTextColor = Color.Gray,
            )
        )
            NavigationBarItem(
                icon = {
                    Icon(
                        Icons.Default.Menu,
                        contentDescription = "Menu",
                        modifier = Modifier
                            .size(28.dp)
                            .shadow(12.dp, spotColor = Color(0xFF8B0000)), // sombra roja
                        tint = Color.Gray)
                },
                label = {
                    Text(
                        "Menu",
                        color = Color(0xFFBFA58A), // dorado viejo medieval
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp
                    )
                },
                selected = false,
                onClick = { navController.navigate("menu") },

                // Colores estilo RPG medieval
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFFB71C1C),
                    selectedTextColor = Color(0xFFB71C1C),
                    unselectedIconColor = Color(0xFFBFA58A),
                    unselectedTextColor = Color(0xFFBFA58A),
                    indicatorColor = Color(0xFF3A1A1A) // aura oscura
                )
            )
        }
    }
