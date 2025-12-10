import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mij.itembox.MainScreen
import com.mij.itembox.data.viewmodel.SettingsViewModel
import com.mij.itembox.ui.auth.LoginScreen

@Composable
fun AuthNavigation(settingsViewModel: SettingsViewModel) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "login") {

        composable("login") { LoginScreen(navController) }
        composable("register") { RegisterScreen(navController) }
        composable("main") { MainScreen(settingsViewModel) }
    }
}
