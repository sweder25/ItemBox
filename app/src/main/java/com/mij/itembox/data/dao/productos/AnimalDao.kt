package com.mij.itembox.data.dao.productos

import com.mij.itembox.data.model.productos.Animal
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AnimalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(animal: Animal)

    @Query("SELECT * FROM animales WHERE id_producto = :id")
    suspend fun getById(id: Long): Animal?
}