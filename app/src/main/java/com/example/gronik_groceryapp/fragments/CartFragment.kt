package com.example.gronik_groceryapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.gronik_groceryapp.ui.cart.CartScreen
import com.example.gronik_groceryapp.viewmodels.CartViewModel

class CartFragment : Fragment() {

    private lateinit var viewModel: CartViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent { CartScreen() }
        }
    }
}
    }
}
