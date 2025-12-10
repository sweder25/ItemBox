package com.mij.itembox.ui.page.menuopciones

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.mij.itembox.data.AppDatabase
import com.mij.itembox.data.predeterminados.Rareza
import com.mij.itembox.data.predeterminados.Resistencia
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
import com.mij.itembox.ui.page.composables.AppBackground

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

    AppBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            androidx.compose.material3.Card(
                modifier = Modifier.fillMaxWidth(),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp),
                colors = androidx.compose.material3.CardDefaults.cardColors(
                    containerColor = Color(0xAA1A1A1A)
                ),
                elevation = androidx.compose.material3.CardDefaults.cardElevation(8.dp)
            ) {

                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Detalles de Producto",
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color(0xFFE6D5A4)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    when (tipo) {
                        "Animal" -> FormularioAnimal(
                            idProducto = idProducto,
                            viewModel = remember {
                                AnimalViewModel(AnimalRepository(database.animalDao()))
                            },
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
            }
        }
    }
}
