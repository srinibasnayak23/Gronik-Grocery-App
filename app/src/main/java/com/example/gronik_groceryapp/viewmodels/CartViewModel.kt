package com.example.gronik_groceryapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gronik_groceryapp.data.dao.ProductDao
import com.example.gronik_groceryapp.data.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModelProvider

class CartViewModel(private val productDao: com.example.gronik_groceryapp.data.dao.ProductDao) : ViewModel() {

    private val _cartProducts: StateFlow<List<com.example.gronik_groceryapp.data.model.Product>> = productDao.getCartProducts()
    val cartProducts: StateFlow<List<com.example.gronik_groceryapp.data.model.Product>> = _cartProducts

    val totalCartValue: StateFlow<Double> = _cartProducts.map { products ->
        products.sumOf { it.price * it.quantity }
    }.toStateFlow(0.0) // Initialize with 0.0

    init {
        viewModelScope.launch {
            // Any initial setup can go here
        }
    }

    fun updateProductQuantity(product: Product, newQuantity: Int) {
        viewModelScope.launch {
            productDao.updateProduct(product.copy(quantity = newQuantity))
        }
    }
}
