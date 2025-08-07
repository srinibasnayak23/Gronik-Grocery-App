package com.example.gronik_groceryapp.ui.orders

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun OrdersScreen(modifier: Modifier = Modifier) {
    // Placeholder data for now
    val dummyOrders = listOf(
        Order(1, "2023-10-26", 55.75),
        Order(2, "2023-10-25", 12.99),
        Order(3, "2023-10-24", 89.50),
        Order(4, "2023-10-23", 3.20)
    )

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(dummyOrders) { order ->
            OrderItem(order = order)
        }
    }
}

@Composable
fun OrderItem(order: Order) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Order ID: ${order.id}")
            Text(text = "Date: ${order.date}")
            Text(text = "Total Amount: $${String.format("%.2f", order.totalAmount)}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OrdersScreenPreview() {
    OrdersScreen(modifier = Modifier)
}

// Placeholder data classes (assuming they are defined elsewhere or will be)
data class Order(val id: Int, val date: String, val totalAmount: Double)