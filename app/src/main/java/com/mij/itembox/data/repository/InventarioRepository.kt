package com.mij.itembox.data.repository

import com.mij.itembox.data.model.Inventario
import com.mij.itembox.data.dao.InventarioDao
import com.mij.itembox.data.model.Producto
import kotlinx.coroutines.flow.Flow

class InventarioRepository(private val dao: InventarioDao){

    val allItems: Flow<List<Inventario>> = dao.getAll()

    suspend fun insert(inventario: Inventario) {
        dao.insert(inventario)
    }

    suspend fun delete(inventario: Inventario) {
        dao.delete(inventario)
    }

}