package com.example.gronik_groceryapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val price: String,
    val imageResId: Int,
    var quantity: Int = 0

)
