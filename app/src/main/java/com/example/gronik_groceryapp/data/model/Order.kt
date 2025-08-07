package com.example.gronik_groceryapp.data.model

data class Order(
    val id: Int,
    val date: String, // Or use java.util.Date or java.time.LocalDate
    val totalAmount: Double
)