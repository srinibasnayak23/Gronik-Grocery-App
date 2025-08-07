package com.example.gronik_groceryapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gronik_groceryapp.data.dao.ProductDao
import com.example.gronik_groceryapp.data.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryFruitsViewModel @Inject constructor(
    private val productDao: ProductDao
) : ViewModel() {

    fun updateProductQuantity(product: Product, newQuantity: Int) {
        viewModelScope.launch {
            productDao.updateProduct(product.copy(quantity = newQuantity))
        }
    }
}