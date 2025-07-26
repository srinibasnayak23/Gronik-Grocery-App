package com.example.gronik_groceryapp.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gronik_groceryapp.R
import com.example.gronik_groceryapp.data.adapter.ProductAdapter
import com.example.gronik_groceryapp.data.model.Product
import com.example.gronik_groceryapp.databinding.FragmentCategoryBinding
import com.example.gronik_groceryapp.databinding.FragmentCategoryFruitsBinding

class CategoryFruitsFragments : Fragment() {

    private var _binding: FragmentCategoryFruitsBinding? = null
    private val binding get() = _binding!!

    private lateinit var productAdapter: ProductAdapter

//    private lateinit var viewModel: CategoryViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryFruitsBinding.inflate(inflater, container, false)

        val sampleData = listOf(
            Product("Apple", "$17.00", R.drawable.apple),
            Product("Strawberry", "$19.00", R.drawable.straberry),
            Product("Banana", "$10.00", R.drawable.banana),
            Product("Apple", "$17.00", R.drawable.apple),
            Product("Guava", "$5.00", R.drawable.guava),
            Product("Strawberry", "$19.00", R.drawable.straberry),
            Product("Banana", "$10.00", R.drawable.banana),
            Product("Apple", "$17.00", R.drawable.apple),
            Product("Strawberry", "$19.00", R.drawable.straberry),
            Product("Banana", "$10.00", R.drawable.banana),
            Product("Apple", "$17.00", R.drawable.apple),
            Product("Strawberry", "$19.00", R.drawable.straberry),
            Product("Banana", "$10.00", R.drawable.banana),
            Product("Guava", "$5.00", R.drawable.guava)
        )

        productAdapter = ProductAdapter(sampleData)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = productAdapter
        }

        binding.backBtn.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = productAdapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
