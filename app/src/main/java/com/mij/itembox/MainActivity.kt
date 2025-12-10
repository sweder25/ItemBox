package com.mij.itembox

import BottomNavigationBar
import com.mij.itembox.ui.page.menuopciones.CrearProductoPaso1
import MenuDropdown
import PerfilPage
import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mij.itembox.data.AppDatabase
import com.mij.itembox.data.predeterminados.rarezasPredefinidas
import com.mij.itembox.data.repository.productos.AnimalRepository
import com.mij.itembox.data.repository.productos.ElaboradoRepository
import com.mij.itembox.data.repository.productos.MineralRepository
import com.mij.itembox.data.repository.productos.ProductoAnimalRepository
import com.mij.itembox.data.repository.productos.VegetalRepository
import com.mij.itembox.data.predeterminados.resistenciasPredefinidas
import com.mij.itembox.data.viewmodel.Fabricadores.ProductoViewModelFabricador
import com.mij.itembox.data.viewmodel.InventarioViewModel
import com.mij.itembox.data.viewmodel.ProductoViewModel
import com.mij.itembox.data.viewmodel.SettingsViewModel
import com.mij.itembox.data.viewmodel.productos.AnimalViewModel
import com.mij.itembox.data.viewmodel.productos.ElaboradoViewModel
import com.mij.itembox.data.viewmodel.productos.MineralViewModel
import com.mij.itembox.data.viewmodel.productos.ProductoAnimalViewModel
import com.mij.itembox.data.viewmodel.productos.VegetalViewModel
import com.mij.itembox.ui.page.AjustesPage
import com.mij.itembox.ui.page.HomePage
import com.mij.itembox.ui.page.menuopciones.CrearInventarioPage
import com.mij.itembox.ui.page.menuopciones.CrearProductoPaso2
import com.mij.itembox.ui.page.menuopciones.TiendaPage
import com.mij.itembox.ui.page.menuopciones.VerInventarioPage
import com.mij.itembox.ui.page.menuopciones.VerProductos
import com.mij.itembox.ui.theme.theme_fondos.AppTheme
import com.mij.itembox.ui.viewmodel.InventarioViewModelFabricador

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val settingsViewModel: SettingsViewModel = viewModel(
                factory = androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            )

            val isDark by settingsViewModel.darkMode.collectAsState()

            AppTheme(darkTheme = isDark) {
                MainScreen(settingsViewModel)
            }
        }
    }
}
@Composable
fun MainScreen(settingsViewModel: SettingsViewModel) {

    val navController = rememberNavController()
    val context = LocalContext.current

    val factory = remember {
        ProductoViewModelFabricador(context.applicationContext as Application)
    }
    val viewModelProducto: ProductoViewModel = viewModel(factory = factory)

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {

            composable("home") { HomePage() }

            composable("perfil") {
                val inventarioViewModel: InventarioViewModel = viewModel(
                    factory = InventarioViewModelFabricador(context.applicationContext as Application)
                )
                PerfilPage(
                    inventarioViewModel = inventarioViewModel,
                    onIrAComprar = { inventarioId ->
                        if (inventarioId != null) {
                            navController.navigate("Tienda/$inventarioId")
                        } else {
                            navController.navigate("CrearInventario")
                        }
                    }
                )
            }

            composable("ajustes") { AjustesPage(settingsViewModel) }

            composable("menu") {
                MenuDropdown(navController = navController)
            }

            composable("CrearProducto") {
                CrearProductoPaso1(
                    viewModel = viewModelProducto,
                    onContinuar = { idProducto, tipo ->
                        navController.navigate("CrearProductoPaso2/$idProducto/$tipo")
                    }
                )
            }

            composable("CrearProductoPaso2/{idProducto}/{tipo}") { backStackEntry ->
                val idProducto = backStackEntry.arguments?.getString("idProducto")?.toLongOrNull()
                    ?: return@composable
                val tipo = backStackEntry.arguments?.getString("tipo") ?: return@composable

                CrearProductoPaso2(
                    idProducto = idProducto,
                    tipo = tipo,
                    onFinalizar = { navController.navigate("home") },
                    rarezas = rarezasPredefinidas,
                    resistencias = resistenciasPredefinidas
                )
            }

            composable("verProductos") {
                val database = remember { AppDatabase.getInstance(context) }

                VerProductos(
                    productoViewModel = viewModelProducto,
                    animalViewModel = remember { AnimalViewModel(AnimalRepository(database.animalDao())) },
                    vegetalViewModel = remember { VegetalViewModel(VegetalRepository(database.vegetalDao())) },
                    mineralViewModel = remember { MineralViewModel(MineralRepository(database.mineralDao())) },
                    elaboradoViewModel = remember { ElaboradoViewModel(ElaboradoRepository(database.elaboradoDao())) },
                    productoAnimalViewModel = remember {
                        ProductoAnimalViewModel(
                            ProductoAnimalRepository(database.productoAnimalDao())
                        )
                    }
                )
            }

            composable("CrearInventario") {
                val inventarioViewModel: InventarioViewModel = viewModel(
                    factory = InventarioViewModelFabricador(context.applicationContext as Application)
                )
                CrearInventarioPage(
                    inventarioViewModel = inventarioViewModel,
                    onInventarioCreado = {
                        navController.navigate("perfil")
                    }
                )
            }

            composable("VerInventarios") {
                val inventarioViewModel: InventarioViewModel = viewModel(
                    factory = InventarioViewModelFabricador(context.applicationContext as Application)
                )
                VerInventarioPage(
                    inventarioViewModel = inventarioViewModel,
                    onSeleccionar = { navController.navigate("perfil")
                    }
                )
            }

            composable("Tienda/{inventarioId}") { backStackEntry ->
                val inventarioId =
                    backStackEntry.arguments?.getString("inventarioId")?.toLongOrNull()
                        ?: return@composable
                TiendaPage(inventarioId)
            }
        }
    }
}
