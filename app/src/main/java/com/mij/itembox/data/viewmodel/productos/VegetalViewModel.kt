package com.mij.itembox.data.viewmodel.productos

import com.mij.itembox.data.model.productos.Vegetal
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mij.itembox.data.repository.productos.VegetalRepository
import kotlinx.coroutines.launch

class VegetalViewModel(private val repository: VegetalRepository) : ViewModel() {
    fun insert(vegetal: Vegetal) {
        viewModelScope.launch {
            repository.insert(vegetal)
        }
    }

    fun getById(id: Long, onResult: (Vegetal?) -> Unit) {
        viewModelScope.launch {
            val result = repository.getById(id)
            onResult(result)
        }
    }
}