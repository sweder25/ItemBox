package com.mij.itembox.ui.page.menuopciones

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.mij.itembox.data.AppDatabase
import com.mij.itembox.data.Rareza
import com.mij.itembox.data.Resistencia
import com.mij.itembox.data.repository.productos.AnimalRepository
import com.mij.itembox.data.repository.productos.ElaboradoRepository
import com.mij.itembox.data.repository.productos.MineralRepository
import com.mij.itembox.data.repository.productos.ProductoAnimalRepository
import com.mij.itembox.data.repository.productos.VegetalRepository
import com.mij.itembox.data.viewmodel.productos.AnimalViewModel
import com.mij.itembox.data.viewmodel.productos.ElaboradoViewModel
import com.mij.itembox.data.viewmodel.productos.MineralViewModel
import com.mij.itembox.data.viewmodel.productos.ProductoAnimalViewModel
import com.mij.itembox.data.viewmodel.productos.VegetalViewModel
import com.mij.itembox.ui.page.formularios.FormularioAnimal
import com.mij.itembox.ui.page.formularios.FormularioElaborado
import com.mij.itembox.ui.page.formularios.FormularioMineral
import com.mij.itembox.ui.page.formularios.FormularioProductoAnimal
import com.mij.itembox.ui.page.formularios.FormularioVegetal


@Composable
fun CrearProductoPaso2(
    idProducto: Long,
    tipo: String,
    onFinalizar: () -> Unit,
    rarezas: List<Rareza>,
    resistencias: List<Resistencia>
) {
    val context = LocalContext.current
    val database = remember { AppDatabase.getInstance(context) }

    when (tipo) {
        "Animal" -> FormularioAnimal(
            idProducto = idProducto,
            viewModel = remember { AnimalViewModel(AnimalRepository(database.animalDao()))},
            rarezas = rarezas,
            onFinalizar = onFinalizar
        )

        "Elaborado" -> FormularioElaborado(
            idProducto = idProducto,
            viewModel = remember {
                ElaboradoViewModel(ElaboradoRepository(database.elaboradoDao()))
            },
            rarezas = rarezas,
            onFinalizar = onFinalizar
        )

        "Mineral" -> FormularioMineral(
            idProducto = idProducto,
            viewModel = remember {
                MineralViewModel(MineralRepository(database.mineralDao()))
            },
            rarezas = rarezas,
            onFinalizar = onFinalizar
        )

        "ProductoAnimal" -> FormularioProductoAnimal(
            idProducto = idProducto,
            viewModel = remember {
                ProductoAnimalViewModel(ProductoAnimalRepository(database.productoAnimalDao()))
            },
            rarezas = rarezas,
            onFinalizar = onFinalizar
        )

        "Vegetal" -> FormularioVegetal(
            idProducto = idProducto,
            viewModel = remember {
                VegetalViewModel(VegetalRepository(database.vegetalDao()))
            },
            rarezas = rarezas,
            resistencias = resistencias,
            onFinalizar = onFinalizar
        )

        else -> Text("Tipo no reconocido: $tipo")
    }
}