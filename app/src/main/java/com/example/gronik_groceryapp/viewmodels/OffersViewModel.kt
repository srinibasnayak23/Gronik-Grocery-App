package com.example.gronik_groceryapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OffersViewModel : ViewModel() {

    private val _text = MutableLiveData("Check out our latest offers!")
    val text: LiveData<String> = _text
}
