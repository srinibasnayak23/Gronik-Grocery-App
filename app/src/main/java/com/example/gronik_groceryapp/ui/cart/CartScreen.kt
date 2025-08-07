package com.example.gronik_groceryapp.ui.cart

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gronik_groceryapp.data.model.Product
import com.example.gronik_groceryapp.ui.product.ProductItem
import com.example.gronik_groceryapp.viewmodels.CartViewModel

@Composable
fun CartScreen(cartViewModel: CartViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()

            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Shopping Cart")
        Spacer(modifier = Modifier.height(16.dp))

        val cartItems by cartViewModel.cartItems.collectAsState()

        if (cartItems.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Your cart is empty.")

            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(cartItems) { item ->
 ProductItem(product = item)
 Spacer(modifier = Modifier.height(8.dp))
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Total: $${calculateTotalPrice(cartItems)}") // Display total price
        }
    }
}

fun calculateTotalPrice(cartItems: List<Product>): Double {
    var total = 0.0
    for (item in cartItems) {
        total += item.price * item.quantity
    }
    return total
}



