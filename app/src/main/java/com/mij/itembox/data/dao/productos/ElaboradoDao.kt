package com.mij.itembox.data.dao.productos

import com.mij.itembox.data.model.productos.Elaborado
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ElaboradoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(elaborado: Elaborado)

    @Query("SELECT * FROM elaborados WHERE id_producto = :id")
    suspend fun getById(id: Long): Elaborado?
}