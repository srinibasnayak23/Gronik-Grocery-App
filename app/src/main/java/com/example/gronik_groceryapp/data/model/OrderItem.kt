package com.example.gronik_groceryapp.data.model

data class OrderItem(
    val id: Int,
    val orderId: Int, // Foreign key to Order
    val productId: Int, // Foreign key to Product
    val productName: String,
    val productPrice: Double,
    val quantity: Int
)