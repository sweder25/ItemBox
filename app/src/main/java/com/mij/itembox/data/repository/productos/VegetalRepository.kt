package com.mij.itembox.data.repository.productos

import com.mij.itembox.data.model.productos.Vegetal
import com.mij.itembox.data.dao.productos.VegetalDao

class VegetalRepository(private val dao: VegetalDao) {
    suspend fun insert(vegetal: Vegetal) = dao.insert(vegetal)
    suspend fun getById(id: Long) = dao.getById(id)
}