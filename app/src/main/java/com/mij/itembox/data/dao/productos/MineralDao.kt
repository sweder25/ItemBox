package com.mij.itembox.data.dao.productos

import com.mij.itembox.data.model.productos.Mineral
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MineralDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(mineral: Mineral)

    @Query("SELECT * FROM minerales WHERE id_producto = :id")
    suspend fun getById(id: Long): Mineral?
}