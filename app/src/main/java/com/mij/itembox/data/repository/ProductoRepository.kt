package com.mij.itembox.data.repository

import com.mij.itembox.data.model.Producto
import com.mij.itembox.data.dao.ProductoDao
import kotlinx.coroutines.flow.Flow

class ProductoRepository(private val dao: ProductoDao) {
    val allItems: Flow<List<Producto>> = dao.getAll()

    suspend fun insert(producto: Producto) {
        dao.insert(producto)
    }

    suspend fun delete(producto: Producto) {
        dao.delete(producto)
    }


    fun getProducto(id: Long) = dao.getProductoFlow(id)
    suspend fun updateImagenPath(id: Long, path: String?) = dao.updateImagenPath(id, path)

}