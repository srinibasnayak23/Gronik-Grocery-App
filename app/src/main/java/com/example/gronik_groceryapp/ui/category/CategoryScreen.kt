package com.example.gronik_groceryapp.ui.category

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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


        val categories = listOf("Fruits", "Vegetables", "Grains", "Dairy", "Meat", "Seafood", "Bakery", "Beverages") // Example categories

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(categories) { category ->
                CategoryItem(categoryName = category) {
                    // Assuming you have a route like "category_products/{categoryName}"
                    // findNavController().navigate("category_products/${category.lowercase()}")
                    // You'll need to pass the category name to the destination
                }
            }
        }
    }
}

@Composable
fun CategoryItem(categoryName: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(

            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .clickable(onClick = onClick),
            contentAlignment = Alignment.Center
        ) {
 Text(
 text = categoryName,
 fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center)
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