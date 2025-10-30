package com.mij.itembox.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "inventarios",
    foreignKeys = [ForeignKey(
        entity = Producto::class,
        parentColumns = ["id_producto"],
        childColumns = ["id_producto"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index(value = ["id_producto"])]
)
data class Inventario(
    @PrimaryKey(autoGenerate = true) val id_inventario: Long = 0,
    val id_producto: Long,
    val cantidad: Long
)