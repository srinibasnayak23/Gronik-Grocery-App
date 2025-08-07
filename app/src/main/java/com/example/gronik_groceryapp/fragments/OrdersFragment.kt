package com.example.gronik_groceryapp.fragments

import android.os.Bundle
import android.view.*
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.gronik_groceryapp.ui.orders.OrdersScreen
import com.example.gronik_groceryapp.viewmodels.OrdersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrdersFragment : Fragment() {

    private lateinit var viewModel: OrdersViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
 return ComposeView(requireContext()).apply {
 setContent {
 OrdersScreen()
 }
 }

    }
}
