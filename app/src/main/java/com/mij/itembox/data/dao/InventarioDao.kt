package com.mij.itembox.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mij.itembox.data.model.Inventario
import kotlinx.coroutines.flow.Flow

@Dao
interface InventarioDao {
    @Query("SELECT * FROM inventarios ORDER BY id_inventario DESC")
    fun getAll(): Flow<List<Inventario>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(inventario: Inventario)

    @Delete
    suspend fun delete(inventario: Inventario)
}