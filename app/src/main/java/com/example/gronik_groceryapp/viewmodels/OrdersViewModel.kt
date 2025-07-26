package com.example.gronik_groceryapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrdersViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "You have no orders yet."
    }
    val text: LiveData<String> = _text
}
