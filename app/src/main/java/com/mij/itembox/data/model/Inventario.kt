package com.mij.itembox.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class Inventario(
    @PrimaryKey(autoGenerate = true) val id_inventario: Long = 0,
    val nombre: String,
    val dinero: Double
)