package com.mij.itembox.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mij.itembox.data.AppDatabase
import com.mij.itembox.data.repository.InventarioOperaciones
import com.mij.itembox.data.repository.InventarioRepository
import com.mij.itembox.data.repository.ProductoRepository
import com.mij.itembox.data.repository.StockRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class InventarioOperacionesViewModel(application: Application) : AndroidViewModel(application) {
    private val productoDao = AppDatabase.getInstance(application).productoDao()
    private val stockDao = AppDatabase.getInstance(application).stockDao()
    private val inventarioDao = AppDatabase.getInstance(application).inventarioDao()

    private val productoRepository = ProductoRepository(productoDao)
    private val stockRepository = StockRepository(stockDao)
    private val inventarioRepository = InventarioRepository(inventarioDao)

    private val operaciones = InventarioOperaciones(productoRepository, stockRepository, inventarioRepository)

    private val _resultadoOperacion = MutableStateFlow<Boolean?>(null)
    val resultadoOperacion: StateFlow<Boolean?> = _resultadoOperacion

    fun comprarProducto(inventarioId: Long, productoId: Long, cantidad: Int) {
        viewModelScope.launch {
            val resultado = operaciones.comprarProducto(inventarioId, productoId, cantidad)
            _resultadoOperacion.value = resultado
        }
    }

    fun venderProducto(inventarioId: Long, productoId: Long, cantidad: Int) {
        viewModelScope.launch {
            val resultado = operaciones.venderProducto(inventarioId, productoId, cantidad)
            _resultadoOperacion.value = resultado
        }
    }

    fun resetResultado() {
        _resultadoOperacion.value = null
    }
}