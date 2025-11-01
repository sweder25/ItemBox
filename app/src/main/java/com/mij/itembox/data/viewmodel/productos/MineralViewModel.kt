package com.mij.itembox.data.viewmodel.productos

import com.mij.itembox.data.model.productos.Mineral
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mij.itembox.data.repository.productos.MineralRepository
import kotlinx.coroutines.launch

class MineralViewModel(private val repository: MineralRepository) : ViewModel() {
    fun insert(mineral: Mineral) {
        viewModelScope.launch {
            repository.insert(mineral)
        }
    }

    fun getById(id: Long, onResult: (Mineral?) -> Unit) {
        viewModelScope.launch {
            val result = repository.getById(id)
            onResult(result)
        }
    }
}