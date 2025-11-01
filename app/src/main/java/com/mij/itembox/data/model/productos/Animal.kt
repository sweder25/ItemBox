package com.mij.itembox.data.model.productos

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.mij.itembox.data.model.Producto

@Entity(
    tableName = "animales",
    foreignKeys = [ForeignKey(
        entity = Producto::class,
        parentColumns = ["id_producto"],
        childColumns = ["id_producto"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Animal(
    @PrimaryKey val id_producto: Long,
    val rareza: Int,
    //val valor_base: Double,
    val descripcion_especie: String,
    val magia: Int,
    //val bioma_ideal: Int,
    //val principal_provehedor: Int,
    val peso: Double
)