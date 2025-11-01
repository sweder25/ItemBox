package com.mij.itembox.data

import com.mij.itembox.data.model.Stock
import com.mij.itembox.data.model.Producto
import com.mij.itembox.data.model.Inventario
import com.mij.itembox.data.dao.ProductoDao
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mij.itembox.data.dao.InventarioDao
import com.mij.itembox.data.dao.StockDao

@Database(entities = [Producto::class, Inventario::class, Stock::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productoDao(): ProductoDao
    abstract fun inventarioDao(): InventarioDao

    abstract fun stockDao(): StockDao
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                                context.applicationContext,
                                AppDatabase::class.java,
                                "itembox_db"
                            ).fallbackToDestructiveMigration(false).build()
                INSTANCE = instance
                instance
            }
        }
    }
}