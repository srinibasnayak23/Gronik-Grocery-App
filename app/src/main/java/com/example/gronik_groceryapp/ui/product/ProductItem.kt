package com.example.gronik_groceryapp.ui.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.gronik_groceryapp.data.dao.ProductDao
import com.example.gronik_groceryapp.data.model.Product

@Composable
fun ProductItem(
 product: Product,
    onQuantityChange: (Product, Int) -> Unit
    ) {
 Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = product.imageResId),
                contentDescription = product.name,
                modifier = Modifier
                    .size(64.dp)
                    .padding(end = 16.dp)
            )
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = product.name, style = MaterialTheme.typography.titleMedium)
                Text(text = "$${product.price}", style = MaterialTheme.typography.bodyMedium)
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                IconButton(onClick = {
                    if (product.quantity > 0) {
                        val updatedProduct = product.copy(quantity = product.quantity - 1)
                        // Use a CoroutineScope to perform database operations
                        // This assumes you have access to a CoroutineScope here,
                        // which is common in composables interacting with ViewModels
                        // If not, you might need to pass a suspend function or use a ViewModel
                        // For simplicity, we'll assume a ViewModel scope or similar is available
                        // and the DAO functions are suspend functions (as is common with Room Kotlin)
                        // In a real app, you'd likely trigger this update from a ViewModel
                        // For direct DAO access in composable, you'd typically use rememberCoroutineScope()
                         // For demonstration, we'll assume a mechanism to call a suspend fun is in place
                         // For this direct DAO call example (less ideal in production UI):
                         // CoroutineScope(Dispatchers.IO).launch { productDao.updateProduct(updatedProduct) }
                    }
                }) {
                    Icon(imageVector = Icons.Default.Remove, contentDescription = "Decrease Quantity")
                }
                Text(text = product.quantity.toString(), style = MaterialTheme.typography.bodyMedium)
                IconButton(onClick = {
                    val updatedProduct = product.copy(quantity = product.quantity + 1)
                     // Similar to the decrease logic, you'd update the database here
                     // CoroutineScope(Dispatchers.IO).launch { productDao.updateProduct(updatedProduct) }
                }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Increase Quantity")
                }
            }
        }
    }
}