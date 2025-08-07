package com.example.gronik_groceryapp.ui.category

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryFruitsScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Fruits") })
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
            //    .padding(paddingValues) // Apply padding from Scaffold
        ) {
            // TODO: Implement displaying the list of fruit products
            items(10) { // Placeholder for now
                Text("Fruit Product Item $it") // Placeholder composable
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCategoryFruitsScreen() {
    CategoryFruitsScreen()
}