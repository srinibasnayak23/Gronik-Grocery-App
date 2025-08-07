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
import com.example.gronik_groceryapp.data.model.Product

@Composable
fun ProductItem(
    product: Product,
    onQuantityChange: (Product, Int) -> Unit // Lambda to handle quantity changes
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
                Text(text = product.name, style = MaterialTheme.typography.bodyMedium)
                Text(text = "$${product.price}", style = MaterialTheme.typography.bodySmall)
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { onQuantityChange(product, product.quantity - 1) }) {
                    Icon(imageVector = Icons.Default.Remove, contentDescription = "Decrease Quantity")
                }
                Text(text = product.quantity.toString(), style = MaterialTheme.typography.bodyMedium)
                IconButton(onClick = { onQuantityChange(product, product.quantity + 1) }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Increase Quantity")
                }
            }
        }
    }
}