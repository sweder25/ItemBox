package com.mij.itembox.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "stock",
    foreignKeys = [
        ForeignKey(
            entity = Inventario::class,
            parentColumns = ["id_inventario"],
            childColumns = ["id_inventario"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(entity = Producto::class, parentColumns = ["id_producto"], childColumns = ["id_producto"], onDelete = ForeignKey.CASCADE)
    ],
    indices = [Index("id_inventario"), Index("id_producto")]
)
data class Stock(
    @PrimaryKey(autoGenerate = true) val id_stock: Long = 0,
    val id_inventario: Long,
    val id_producto: Long,
    val cantidad: Int
)