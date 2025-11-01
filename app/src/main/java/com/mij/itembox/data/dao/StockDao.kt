package com.mij.itembox.data.dao


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mij.itembox.data.dataclass.ProductoConCantidad
import com.mij.itembox.data.model.Stock
import kotlinx.coroutines.flow.Flow

@Dao
interface StockDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarStock(stock: Stock)

    @Query("SELECT * FROM stock WHERE id_inventario = :inventarioId")
    fun obtenerStockPorInventario(inventarioId: Long): Flow<List<Stock>>

    @Query("SELECT * FROM stock WHERE id_inventario = :inventarioId AND id_producto = :productoId")
    suspend fun obtenerStockDeProducto(inventarioId: Long, productoId: Long): Stock?

    @Query("UPDATE stock SET cantidad = :nuevaCantidad WHERE id_stock = :stockId")
    suspend fun actualizarCantidad(stockId: Long, nuevaCantidad: Int)

    @Delete
    suspend fun eliminarStock(stock: Stock)

    @Query("""
    SELECT productos.nombre, stock.cantidad 
    FROM stock 
    INNER JOIN productos ON productos.id_producto = stock.id_producto 
    WHERE stock.id_inventario = :inventarioId
""")
    suspend fun getProductosConCantidad(inventarioId: Long): List<ProductoConCantidad>
}

