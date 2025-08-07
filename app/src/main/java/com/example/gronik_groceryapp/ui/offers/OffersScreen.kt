package com.example.gronik_groceryapp.ui.offers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun OffersScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // TODO: Implement UI for displaying offers
        Text(text = "Offers Screen (Implementation Pending)")
        // Example placeholder for an offer item:
        // OfferItem(offerTitle = "Special Discount", offerDescription = "Get 20% off on all fruits!")
    }
}

@Preview(showBackground = true)
@Composable
fun OffersScreenPreview() {
    OffersScreen()
}

// TODO: Create a composable function for an individual offer item (e.g., OfferItem)
/*
@Composable
fun OfferItem(offerTitle: String, offerDescription: String) {
    // Implement the UI for a single offer item
}
*/