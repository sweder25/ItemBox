package com.mij.itembox.data.repository

import com.mij.itembox.data.model.Inventario
import com.mij.itembox.data.dao.InventarioDao
import kotlinx.coroutines.flow.Flow

class InventarioRepository(private val dao: InventarioDao) {

    val allItems: Flow<List<Inventario>> = dao.getAll()

    suspend fun insert(inventario: Inventario) {
        dao.insert(inventario)
    }

    suspend fun delete(inventario: Inventario) {
        dao.delete(inventario)
    }

    suspend fun actualizarDinero(idInventario: Long, nuevoMonto: Double) {
        dao.actualizarDinero(idInventario, nuevoMonto)
    }
    fun getInventario(id: Long): Flow<Inventario> {
        return dao.getById(id)
    }

    suspend fun descontarDinero(idInventario: Long, monto: Double) {
        val inventario = dao.getByIdSuspend(idInventario)
        val nuevoMonto = inventario.dinero - monto
        dao.actualizarDinero(idInventario, nuevoMonto)
    }

    suspend fun getByIdSuspend(id: Long): Inventario {
        return dao.getByIdSuspend(id)
    }

    fun getById(id: Long): Flow<Inventario> {
        return dao.getById(id)
    }
}