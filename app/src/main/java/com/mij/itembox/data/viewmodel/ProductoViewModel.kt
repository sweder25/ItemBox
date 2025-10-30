package com.mij.itembox.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mij.itembox.data.AppDatabase
import com.mij.itembox.data.model.Producto
import com.mij.itembox.data.repository.ProductoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ProductoViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = AppDatabase.Companion.getDatabase(application).productoDao()
    private val repository = ProductoRepository(dao)

    val allItems: Flow<List<Producto>> = repository.allItems

    fun insert(producto: Producto) {
        viewModelScope.launch { repository.insert(producto) }
    }

    fun productoFlow(id: Long) = repository.getProducto(id)

    // Llamar desde UI cuando ya tengas el path (String) devuelto por saveImageToInternalStorage
    fun updateImagen(productId: Long, path: String?) {
        viewModelScope.launch {
            repository.updateImagenPath(productId, path)
        }
    }

    // Eliminar producto y su imagen interna (si existe)
    fun deleteProductoAndImage(producto: com.mij.itembox.data.model.Producto) {
        viewModelScope.launch {
            // borrar fichero si existe
            producto.imagenPath?.let { relPath ->
                try {
                    val f = java.io.File(getApplication<Application>().filesDir, relPath)
                    if (f.exists()) f.delete()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            repository.delete(producto)
        }
    }
}