package com.example.gronik_groceryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroceryApp()
        }
    }
}

@Composable
fun GroceryApp() {
    // This will be the root of your Compose UI
    // We will build the rest of the UI here
}
