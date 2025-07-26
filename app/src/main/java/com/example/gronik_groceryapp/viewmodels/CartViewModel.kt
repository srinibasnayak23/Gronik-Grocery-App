package com.example.gronik_groceryapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CartViewModel : ViewModel() {

    private val _text = MutableLiveData("Your cart is empty.")
    val text: LiveData<String> = _text
}
