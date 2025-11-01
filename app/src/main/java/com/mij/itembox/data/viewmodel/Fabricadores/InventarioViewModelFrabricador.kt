package com.mij.itembox.ui.viewmodel


import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mij.itembox.data.AppDatabase
import com.mij.itembox.data.repository.InventarioRepository
import com.mij.itembox.data.repository.StockRepository
import com.mij.itembox.data.viewmodel.InventarioViewModel

class InventarioViewModelFabricador(
    private val application: Application
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val database = AppDatabase.getInstance(application)
        val inventarioDao = database.inventarioDao()
        val stockDao = database.stockDao()

        val inventarioRepository = InventarioRepository(inventarioDao)
        val stockRepository = StockRepository(stockDao)

        return InventarioViewModel(application, stockRepository) as T
    }
}