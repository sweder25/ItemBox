package com.mij.itembox.data.viewmodel.Fabricadores

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mij.itembox.data.viewmodel.ProductoViewModel

class ProductoViewModelFabricador(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProductoViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}