package com.mij.itembox.data.model.productos

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.mij.itembox.data.model.Producto

@Entity(
    tableName = "productos_animales",
    foreignKeys = [ForeignKey(
        entity = Producto::class,
        parentColumns = ["id_producto"],
        childColumns = ["id_producto"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class ProductoAnimal(
    @PrimaryKey val id_producto: Long,
    val rareza: Int,
    val descripcion_origen: String,
    val descripcion_propiedades: String,
    val magia: Int,
    //val principal_provehedor: Int,
    //val valor_base: Double,
    val peso: Double
)