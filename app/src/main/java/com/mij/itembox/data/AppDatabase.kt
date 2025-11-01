package com.mij.itembox.data

import com.mij.itembox.data.model.Stock
import com.mij.itembox.data.model.Producto
import com.mij.itembox.data.model.Inventario
import com.mij.itembox.data.model.productos.Animal
import com.mij.itembox.data.model.productos.Vegetal
import com.mij.itembox.data.model.productos.Mineral
import com.mij.itembox.data.model.productos.Elaborado
import com.mij.itembox.data.model.productos.ProductoAnimal
import com.mij.itembox.data.dao.ProductoDao
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mij.itembox.data.dao.InventarioDao
import com.mij.itembox.data.dao.StockDao
import com.mij.itembox.data.dao.productos.AnimalDao
import com.mij.itembox.data.dao.productos.ElaboradoDao
import com.mij.itembox.data.dao.productos.MineralDao
import com.mij.itembox.data.dao.productos.ProductoAnimalDao
import com.mij.itembox.data.dao.productos.VegetalDao

@Database(entities = [Producto::class, Inventario::class, Stock::class, Animal::class, Vegetal::class, Mineral::class, Elaborado::class, ProductoAnimal::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productoDao(): ProductoDao
    abstract fun inventarioDao(): InventarioDao

    abstract fun stockDao(): StockDao

    abstract fun animalDao(): AnimalDao

    abstract fun vegetalDao(): VegetalDao

    abstract fun mineralDao(): MineralDao

    abstract fun elaboradoDao(): ElaboradoDao

    abstract fun productoAnimalDao(): ProductoAnimalDao


    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "itembox.db"
                )
                    .fallbackToDestructiveMigration(false)
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }





}