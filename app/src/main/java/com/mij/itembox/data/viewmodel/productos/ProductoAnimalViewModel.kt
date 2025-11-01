package com.mij.itembox.data.viewmodel.productos

import com.mij.itembox.data.model.productos.ProductoAnimal
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mij.itembox.data.repository.productos.ProductoAnimalRepository
import kotlinx.coroutines.launch

class ProductoAnimalViewModel(private val repository: ProductoAnimalRepository) : ViewModel() {
    fun insert(productoAnimal: ProductoAnimal) {
        viewModelScope.launch {
            repository.insert(productoAnimal)
        }
    }

    fun getById(id: Long, onResult: (ProductoAnimal?) -> Unit) {
        viewModelScope.launch {
            val result = repository.getById(id)
            onResult(result)
        }
    }
}