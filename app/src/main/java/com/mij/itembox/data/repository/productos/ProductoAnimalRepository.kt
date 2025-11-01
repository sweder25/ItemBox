package com.mij.itembox.data.repository.productos

import com.mij.itembox.data.model.productos.ProductoAnimal
import com.mij.itembox.data.dao.productos.ProductoAnimalDao

class ProductoAnimalRepository(private val dao: ProductoAnimalDao) {
    suspend fun insert(productoAnimal: ProductoAnimal) = dao.insert(productoAnimal)
    suspend fun getById(id: Long) = dao.getById(id)
}