package com.example.gronik_groceryapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gronik_groceryapp.data.dao.ProductDao
import com.example.gronik_groceryapp.data.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val productDao: ProductDao) : ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    init {
        viewModelScope.launch {
            productDao.getAllProducts().collect { _products.value = it }
        }
    }
}