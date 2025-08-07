package com.example.gronik_groceryapp.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.compose.ui.platform.ComposeView
import com.example.gronik_groceryapp.ui.category.CategoryScreen

class CategoryFragment : Fragment() {


//    private lateinit var viewModel: CategoryViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
 return ComposeView(requireContext()).apply {
 setContent {
 CategoryScreen()
 }
 }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun openFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
