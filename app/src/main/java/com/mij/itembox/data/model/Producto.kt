package com.mij.itembox.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "productos")
data class Producto(
    @PrimaryKey(autoGenerate = true) val id_producto: Long = 0,
    val nombre: String,
    val tipo: String,
    val precio: Double,
    val imagenPath: String? = null
)


