package com.mij.itembox.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mij.itembox.data.AppDatabase
import com.mij.itembox.data.model.Stock
import com.mij.itembox.data.repository.StockRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class StockViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = AppDatabase.getInstance(application).stockDao()
    private val repository = StockRepository(dao)

    fun getStockPorInventario(inventarioId: Long): Flow<List<Stock>> {
        return repository.getStockPorInventario(inventarioId)
    }

    fun agregarProducto(inventarioId: Long, productoId: Long, cantidad: Int) {
        viewModelScope.launch {
            repository.agregarProductoAlInventario(inventarioId, productoId, cantidad)
        }
    }

    fun actualizarCantidad(stockId: Long, nuevaCantidad: Int) {
        viewModelScope.launch {
            repository.actualizarCantidad(stockId, nuevaCantidad)
        }
    }

    fun eliminarStock(stock: Stock) {
        viewModelScope.launch {
            repository.eliminarStock(stock)
        }
    }

    suspend fun getStockDirecto(inventarioId: Long, productoId: Long): Stock? {
        return repository.getStockDeProducto(inventarioId, productoId)
    }
}