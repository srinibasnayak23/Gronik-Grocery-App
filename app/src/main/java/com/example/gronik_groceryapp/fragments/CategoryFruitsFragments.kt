package com.example.gronik_groceryapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.compose.ui.platform.ComposeView
import com.example.gronik_groceryapp.ui.category.CategoryFruitsScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFruitsFragments : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                CategoryFruitsScreen()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
