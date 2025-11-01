package com.mij.itembox.data.viewmodel.productos

import com.mij.itembox.data.model.productos.Animal
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mij.itembox.data.repository.productos.AnimalRepository
import kotlinx.coroutines.launch

class AnimalViewModel(private val repository: AnimalRepository) : ViewModel() {
    fun insert(animal: Animal) {
        viewModelScope.launch {
            repository.insert(animal)
        }
    }

    fun getById(id: Long, onResult: (Animal?) -> Unit) {
        viewModelScope.launch {
            val result = repository.getById(id)
            onResult(result)
        }
    }
}