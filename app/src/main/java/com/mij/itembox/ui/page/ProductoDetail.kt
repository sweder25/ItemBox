package com.mij.itembox.ui.page

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.mij.itembox.data.model.Producto
import com.mij.itembox.data.viewmodel.ProductoViewModel
import com.mij.itembox.util.saveImageToInternalStorage
import kotlinx.coroutines.launch
import java.io.File

@Composable
fun ProductoDetail(productId: Long, vm: ProductoViewModel = viewModel()) {
    val context = LocalContext.current
    val productoState = vm.productoFlow(productId)
    val producto by productoState.collectAsState(initial = null)
    val coroutineScope = rememberCoroutineScope()

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument()
    ) { uri: Uri? ->
        uri?.let { picked ->
            try {
                context.contentResolver.takePersistableUriPermission(picked, Intent.FLAG_GRANT_READ_URI_PERMISSION)
            } catch (e: Exception) { }

            // guardar imagen en background
            val filename = "producto_${productId}_${System.currentTimeMillis()}.jpg"
            coroutineScope.launch {
                val saved = saveImageToInternalStorage(context, picked, filename)
                vm.updateImagen(productId, saved)
            }
        }
    }

    Column {
        producto?.let { p: Producto ->
            Row {
                val imagePath = p.imagenPath
                if (!imagePath.isNullOrEmpty()) {
                    val file = File(context.filesDir, imagePath)
                    if (file.exists()) {
                        AsyncImage(model = file, contentDescription = p.nombre, modifier = Modifier.size(96.dp))
                    } else {
                        Text("No image file")
                    }
                } else {
                    Text("Sin imagen")
                }
            }

            Button(onClick = { launcher.launch(arrayOf("image/*")) }) {
                Text("Seleccionar imagen")
            }
        } ?: Text("Cargando producto...")
    }
}
