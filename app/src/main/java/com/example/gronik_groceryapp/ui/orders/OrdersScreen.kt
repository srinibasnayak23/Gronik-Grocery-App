package com.example.gronik_groceryapp.ui.orders

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun OrdersScreen() {
    // Placeholder for the Orders screen UI
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Orders Screen (Coming Soon!)")
        // TODO: Implement UI to display past orders
    }
}

@Preview(showBackground = true)
@Composable
fun OrdersScreenPreview() {
    OrdersScreen()
}