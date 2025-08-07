package com.example.gronik_groceryapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gronik_groceryapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroceryApp() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
 NavHost(
 navController = navController,
 startDestination = Screen.Home.route,
 modifier = Modifier.padding(innerPadding)
 ) {
            composable(Screen.Home.route) {
 // Replace with your actual Home Screen Composable
 // HomeScreen()
            }
            composable(Screen.Category.route) {
 // Replace with your actual Category Screen Composable
 // CategoryScreen()
            }
            composable(Screen.Cart.route) {
 // Replace with your actual Cart Screen Composable
 // CartScreen()
            }
            composable(Screen.Offers.route) {
 // Replace with your actual Offers Screen Composable
 // OffersScreen()
            }
            composable(Screen.Orders.route) {
                // Placeholder for Orders Screen Composable
                Text("Orders Screen")
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        Screen.Home,
        Screen.Category,
        Screen.Cart,
        Screen.Offers,
        Screen.Orders
    )
    NavigationBar {
        items.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(screen.icon!!, contentDescription = null) },
                label = { Text(stringResource(screen.resourceId)) },
                selected = navController.currentDestination?.route == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        // Avoid building up a large stack of destinations on the back stack as users select items
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                        // Launch as a single top to avoid duplicate copies of the same destination when reselecting the same item
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

sealed class Screen(val route: String, @StringRes val resourceId: Int, val icon: ImageVector? = null) {
    object Home : Screen("home", R.string.title_home, Icons.Filled.Home)
    object Category : Screen("category", R.string.title_category, Icons.Filled.Category)
    object Cart : Screen("cart", R.string.title_cart, Icons.Filled.ShoppingCart)
    object Offers : Screen("offers", R.string.title_offers, Icons.Filled.Discount) // Assuming you have an icon for offers
    object Orders : Screen("orders", R.string.title_orders, Icons.Filled.Receipt) // Assuming you have an icon for orders
}