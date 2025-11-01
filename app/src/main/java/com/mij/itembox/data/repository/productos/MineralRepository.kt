package com.mij.itembox.data.repository.productos

import com.mij.itembox.data.model.productos.Mineral
import com.mij.itembox.data.dao.productos.MineralDao

class MineralRepository(private val dao: MineralDao) {
    suspend fun insert(mineral: Mineral) = dao.insert(mineral)
    suspend fun getById(id: Long) = dao.getById(id)
}