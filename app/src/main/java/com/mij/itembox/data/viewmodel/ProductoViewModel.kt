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
    private val dao = AppDatabase.Companion.getInstance(application).productoDao()
    private val repository = ProductoRepository(dao)

    val allProducto: Flow<List<Producto>> = repository.allProducto

    fun insert(producto: Producto) {
        viewModelScope.launch { repository.insert(producto) }
    }

    fun productoFlow(id: Long) = repository.getProducto(id)


    fun updateImagen(productId: Long, path: String?) {
        viewModelScope.launch {
            repository.updateImagenPath(productId, path)
        }
    }

    fun insertYRetornaId(producto: Producto, onResult: (Long) -> Unit) {
        viewModelScope.launch {
            val id = repository.insertYRetornaId(producto)
            onResult(id)
        }
    }

}