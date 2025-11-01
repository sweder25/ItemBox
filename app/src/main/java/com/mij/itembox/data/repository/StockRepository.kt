package com.mij.itembox.data.repository

import com.mij.itembox.data.dao.StockDao
import com.mij.itembox.data.model.Stock
import kotlinx.coroutines.flow.Flow

class StockRepository(private val dao: StockDao) {

    fun getStockPorInventario(inventarioId: Long): Flow<List<Stock>> {
        return dao.obtenerStockPorInventario(inventarioId)
    }

    suspend fun getStockDeProducto(inventarioId: Long, productoId: Long): Stock? {
        return dao.obtenerStockDeProducto(inventarioId, productoId)
    }

    suspend fun insertarStock(stock: Stock) {
        dao.insertarStock(stock)
    }

    suspend fun actualizarCantidad(stockId: Long, nuevaCantidad: Int) {
        dao.actualizarCantidad(stockId, nuevaCantidad)
    }

    suspend fun eliminarStock(stock: Stock) {
        dao.eliminarStock(stock)
    }

    suspend fun agregarProductoAlInventario(
        inventarioId: Long,
        productoId: Long,
        cantidad: Int
    ) {
        val stockExistente = dao.obtenerStockDeProducto(inventarioId, productoId)

        if (stockExistente != null) {
            val nuevaCantidad = stockExistente.cantidad + cantidad
            dao.actualizarCantidad(stockExistente.id_stock, nuevaCantidad)
        } else {
            val nuevoStock = Stock(
                id_inventario = inventarioId,
                id_producto = productoId,
                cantidad = cantidad
            )
            dao.insertarStock(nuevoStock)
        }
    }

    suspend fun realizarVenta(
        inventarioId: Long,
        productoId: Long,
        cantidadVendida: Int,
        productoRepository: ProductoRepository,
        inventarioRepository: InventarioRepository
    ): Boolean {
        val stock = dao.obtenerStockDeProducto(inventarioId, productoId)
        val producto = productoRepository.getProductoDirecto(productoId)
        val inventario = inventarioRepository.getByIdSuspend(inventarioId)

        if (stock == null || stock.cantidad < cantidadVendida) return false
        val totalPrecio = producto.precio * cantidadVendida
        if (inventario.dinero < totalPrecio) return false

        val nuevaCantidad = stock.cantidad - cantidadVendida
        val nuevoDinero = inventario.dinero - totalPrecio

        dao.actualizarCantidad(stock.id_stock, nuevaCantidad)
        inventarioRepository.actualizarDinero(inventarioId, nuevoDinero)

        return true
    }


}