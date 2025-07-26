package com.example.gronik_groceryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gronik_groceryapp.databinding.ActivityMainBinding
import com.example.gronik_groceryapp.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load HomeFragment first
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.fragmentContainer.id, HomeFragment())
                .commit()
        }

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> openFragment(HomeFragment())
                R.id.navigation_cart -> openFragment(CartFragment())
                R.id.navigation_offers -> openFragment(OffersFragment())
                R.id.navigation_orders -> openFragment(OrdersFragment())
                else -> true
            }
        }
    }

    private fun openFragment(fragment: androidx.fragment.app.Fragment): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .commit()
        return true
    }
}
