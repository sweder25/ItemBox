package com.mij.itembox.data.dao.productos

import com.mij.itembox.data.model.productos.Vegetal
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface VegetalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vegetal: Vegetal)

    @Query("SELECT * FROM vegetales WHERE id_producto = :id")
    suspend fun getById(id: Long): Vegetal?
}