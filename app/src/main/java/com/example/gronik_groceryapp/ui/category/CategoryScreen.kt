package com.example.gronik_groceryapp.ui.category

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gronik_groceryapp.ui.theme.Gronik_GroceryAppTheme

@Composable
fun CategoryScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = "Product Categories", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        // Placeholder for displaying categories
        // You can replace this with a LazyColumn or LazyVerticalGrid to display actual categories
        CategoryItemPlaceholder("Fruits")
        CategoryItemPlaceholder("Vegetables")
        CategoryItemPlaceholder("Grains")
        CategoryItemPlaceholder("Dairy")
        // Add more placeholder items as needed
    }
}

@Composable
fun CategoryItemPlaceholder(categoryName: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = categoryName, style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryScreenPreview() {
    Gronik_GroceryAppTheme {
        CategoryScreen()
    }
}