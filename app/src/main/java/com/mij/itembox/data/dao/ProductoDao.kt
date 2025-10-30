package com.mij.itembox.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mij.itembox.data.model.Producto
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductoDao {
    @Query("SELECT * FROM productos ORDER BY id_producto DESC")
    fun getAll(): Flow<List<Producto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(producto: Producto)

    @Delete
    suspend fun delete(producto: Producto)

    @Query("UPDATE productos SET imagenPath = :path WHERE id_producto = :id")
    suspend fun updateImagenPath(id: Long, path: String?)

    @Query("SELECT * FROM productos WHERE id_producto = :id")
    fun getProductoFlow(id: Long): Flow<Producto>
}