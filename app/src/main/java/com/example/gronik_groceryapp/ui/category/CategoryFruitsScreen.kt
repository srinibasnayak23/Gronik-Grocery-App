package com.example.gronik_groceryapp.ui.category

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gronik_groceryapp.data.model.Product
import com.example.gronik_groceryapp.data.database.ProductDatabase
import com.example.gronik_groceryapp.ui.product.ProductItem
import com.example.gronik_groceryapp.viewmodels.CategoryFruitsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryFruitsScreen(
    // Provide a factory for the ViewModel to inject ProductDao
    viewModel: CategoryFruitsViewModel = viewModel(
        factory = CategoryFruitsViewModelFactory(LocalContext.current)
    )
) {
    // The ViewModel now handles fetching data, so we observe its state
    val fruitProducts by viewModel.fruitProducts.collectAsState()
    // Pass the ProductDao to ProductItem for quantity updates
    val productDao = ProductDatabase.getDatabase(LocalContext.current).productDao()
    val fruitProducts by viewModel.fruitProducts.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Fruits") })
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp)
        ) {
            items(fruitProducts) { product ->
                ProductItem(product = product) { updatedProduct, newQuantity ->
                    viewModel.updateProductQuantity(updatedProduct, newQuantity)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCategoryFruitsScreen() {
    // For preview purposes, you might need to mock the ViewModel or provide sample data
    CategoryFruitsScreen()
}

// ViewModel Factory to provide ProductDao
class CategoryFruitsViewModelFactory(private val context: android.content.Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CategoryFruitsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CategoryFruitsViewModel(ProductDatabase.getDatabase(context).productDao()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}