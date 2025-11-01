package com.mij.itembox

import AjustesPage
import BottomNavigationBar
import CrearProductoPaso1
import HomePage
import MenuDropdown
import PerfilPage
import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mij.itembox.data.AppDatabase
import com.mij.itembox.data.model.Producto
import com.mij.itembox.data.rarezasPredefinidas
import com.mij.itembox.data.repository.productos.AnimalRepository
import com.mij.itembox.data.repository.productos.ElaboradoRepository
import com.mij.itembox.data.repository.productos.MineralRepository
import com.mij.itembox.data.repository.productos.ProductoAnimalRepository
import com.mij.itembox.data.repository.productos.VegetalRepository
import com.mij.itembox.data.resistenciasPredefinidas
import com.mij.itembox.data.viewmodel.ProductoViewModelFabricador
import com.mij.itembox.data.viewmodel.ProductoViewModel
import com.mij.itembox.data.viewmodel.productos.AnimalViewModel
import com.mij.itembox.data.viewmodel.productos.ElaboradoViewModel
import com.mij.itembox.data.viewmodel.productos.MineralViewModel
import com.mij.itembox.data.viewmodel.productos.ProductoAnimalViewModel
import com.mij.itembox.data.viewmodel.productos.VegetalViewModel
import com.mij.itembox.ui.page.CrearProductoPaso2
import com.mij.itembox.ui.page.VerProductos
import com.mij.itembox.ui.theme.ItemBoxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ItemBoxTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val factory = remember { ProductoViewModelFabricador(context.applicationContext as Application) }
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
            composable("perfil") { PerfilPage() }
            composable("ajustes") { AjustesPage() }
            composable ("menu"){ MenuDropdown(navController = navController, modifier = Modifier.padding(innerPadding)) }
            composable("CrearProducto") {
                CrearProductoPaso1(viewModel = viewModelProducto, onContinuar = { idProducto, tipo ->
                    navController.navigate("CrearProductoPaso2/$idProducto/$tipo")
                },modifier = Modifier.padding(innerPadding))
            }
            composable("CrearProductoPaso2/{idProducto}/{tipo}") { backStackEntry ->
                val idProducto = backStackEntry.arguments?.getString("idProducto")?.toLongOrNull() ?: return@composable
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
                val context = LocalContext.current
                val database = remember { AppDatabase.getInstance(context) }

                VerProductos(
                    productoViewModel = viewModelProducto,
                    animalViewModel = remember { AnimalViewModel(AnimalRepository(database.animalDao())) },
                    vegetalViewModel = remember { VegetalViewModel(VegetalRepository(database.vegetalDao())) },
                    mineralViewModel = remember { MineralViewModel(MineralRepository(database.mineralDao())) },
                    elaboradoViewModel = remember { ElaboradoViewModel(ElaboradoRepository(database.elaboradoDao())) },
                    productoAnimalViewModel = remember { ProductoAnimalViewModel(
                        ProductoAnimalRepository(database.productoAnimalDao())
                    ) }
                )
            }



        }
    }
}



