package com.mij.itembox.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "regiones")
data class Region(
    @PrimaryKey(autoGenerate = true) val id_region: Long = 0,
    val nombre: String,
    val bioma_principal: Long
)