package com.mij.itembox.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "distanciaregiones")
data class DistanciaEntreRegiones(
    @PrimaryKey(autoGenerate = true) val id_der: Long = 0,
    val id_region_a: Long,
    val id_region_b: Long,
    val distancia: Int,
)