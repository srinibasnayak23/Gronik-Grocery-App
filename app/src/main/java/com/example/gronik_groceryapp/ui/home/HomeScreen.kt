package com.example.gronik_groceryapp.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gronik_groceryapp.ui.theme.Gronik_GroceryAppTheme
import com.example.gronik_groceryapp.ui.product.ProductItem
import androidx.compose.foundation.lazy.items
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gronik_groceryapp.viewmodels.HomeViewModels

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Search Bar Placeholder
        OutlinedTextField(
            value = "", // Replace with state
            onValueChange = { /* Handle search text change */ },
            label = { Text("Search for products") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Banners Placeholder
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Banner Area")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Product List Placeholder
        Text(
            text = "Featured Products",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        val homeViewModel: HomeViewModels = viewModel()
        val products by homeViewModel.products.collectAsState()

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(products) { product ->
 ProductItem(product = product)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Gronik_GroceryAppTheme {
        HomeScreen()
    }
}