package com.mij.itembox.data.viewmodel.productos

import com.mij.itembox.data.model.productos.Elaborado
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mij.itembox.data.repository.productos.ElaboradoRepository
import kotlinx.coroutines.launch

class ElaboradoViewModel(private val repository: ElaboradoRepository) : ViewModel() {
    fun insert(elaborado: Elaborado) {
        viewModelScope.launch {
            repository.insert(elaborado)
        }
    }

    fun getById(id: Long, onResult: (Elaborado?) -> Unit) {
        viewModelScope.launch {
            val result = repository.getById(id)
            onResult(result)
        }
    }
}