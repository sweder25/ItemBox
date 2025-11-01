package com.mij.itembox.data.repository

class InventarioOperaciones(
    private val productoRepository: ProductoRepository,
    private val stockRepository: StockRepository,
    private val inventarioRepository: InventarioRepository
) {

    suspend fun comprarProducto(inventarioId: Long, productoId: Long, cantidad: Int): Boolean {
        val producto = productoRepository.getProductoDirecto(productoId)
        val costoTotal = producto.precio * cantidad
        val inventario = inventarioRepository.getByIdSuspend(inventarioId)

        if (inventario.dinero < costoTotal) return false

        inventarioRepository.actualizarDinero(inventarioId, inventario.dinero - costoTotal)
        stockRepository.agregarProductoAlInventario(inventarioId, productoId, cantidad)
        return true
    }

    suspend fun venderProducto(inventarioId: Long, productoId: Long, cantidad: Int): Boolean {
        val producto = productoRepository.getProductoDirecto(productoId)
        val stock = stockRepository.getStockDeProducto(inventarioId, productoId) ?: return false
        if (stock.cantidad < cantidad) return false

        val dineroGanado = producto.precio * cantidad
        stockRepository.actualizarCantidad(stock.id_stock, stock.cantidad - cantidad)

        val inventario = inventarioRepository.getByIdSuspend(inventarioId)
        inventarioRepository.actualizarDinero(inventarioId, inventario.dinero + dineroGanado)
        return true
    }
}