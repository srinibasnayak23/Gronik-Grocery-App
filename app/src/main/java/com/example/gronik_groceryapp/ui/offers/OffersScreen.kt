package com.example.gronik_groceryapp.ui.offers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gronik_groceryapp.R
import com.example.gronik_groceryapp.data.model.Offer

@Composable
fun OffersScreen() {
    // Placeholder list of offers
    val offers = listOf(
        Offer(1, "Summer Sale!", "Get up to 50% off on select items.", R.drawable.offer1_bg),
        Offer(2, "Buy One Get One Free", "On all fresh produce this week.", R.drawable.offert2_bg),
        Offer(3, "Weekend Special", "20% off on dairy products.", R.drawable.img_3)
    )
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(5) { // Placeholder for 5 offer items
                OfferItem(offerTitle = "Special Offer $it", offerDescription = "Get some great discount on item $it!")
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun OffersScreenPreview() {


@Composable
fun OfferItem(offerTitle: String, offerDescription: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
 ) {
 Image(
 painter = painterResource(id = offerImageResId),
 contentDescription = offerTitle,
 modifier = Modifier.fillMaxWidth().height(150.dp),
 contentScale = ContentScale.Crop
 )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = offerDescription, style = MaterialTheme.typography.bodyMedium)
        }
    }
}


