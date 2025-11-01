package com.mij.itembox.data.dao.productos

import com.mij.itembox.data.model.productos.ProductoAnimal
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductoAnimalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(productoAnimal: ProductoAnimal)

    @Query("SELECT * FROM productos_animales WHERE id_producto = :id")
    suspend fun getById(id: Long): ProductoAnimal?
}