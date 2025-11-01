package com.mij.itembox.data.repository.productos

import com.mij.itembox.data.model.productos.Animal
import com.mij.itembox.data.dao.productos.AnimalDao

class AnimalRepository(private val dao: AnimalDao) {
    suspend fun insert(animal: Animal) = dao.insert(animal)
    suspend fun getById(id: Long) = dao.getById(id)
}