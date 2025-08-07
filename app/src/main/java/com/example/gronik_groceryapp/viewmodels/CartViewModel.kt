package com.example.gronik_groceryapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gronik_groceryapp.data.dao.ProductDao
import com.example.gronik_groceryapp.data.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CartViewModel(private val productDao: ProductDao) : ViewModel() {

    private val _cartProducts = MutableStateFlow<List<Product>>(emptyList())
    val cartProducts: StateFlow<List<Product>> = _cartProducts

    init {
        viewModelScope.launch {
            productDao.getCartProducts().collect { _cartProducts.value = it }
        }
    }
}
