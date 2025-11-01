package com.mij.itembox.data.repository.productos

import com.mij.itembox.data.model.productos.Elaborado
import com.mij.itembox.data.dao.productos.ElaboradoDao

class ElaboradoRepository(private val dao: ElaboradoDao) {
    suspend fun insert(elaborado: Elaborado) = dao.insert(elaborado)
    suspend fun getById(id: Long) = dao.getById(id)
}