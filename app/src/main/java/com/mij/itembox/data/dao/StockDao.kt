import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface StockDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarStock(stock: Stock)

    @Query("SELECT * FROM stock WHERE inventario_id = :inventarioId")
    fun obtenerStockPorInventario(inventarioId: Long): Flow<List<Stock>>

    @Query("SELECT * FROM stock WHERE inventario_id = :inventarioId AND producto_id = :productoId")
    suspend fun obtenerStockDeProducto(inventarioId: Long, productoId: Long): Stock?

    @Query("UPDATE stock SET cantidad = :nuevaCantidad WHERE id_stock = :stockId")
    suspend fun actualizarCantidad(stockId: Long, nuevaCantidad: Int)

    @Delete
    suspend fun eliminarStock(stock: Stock)
}