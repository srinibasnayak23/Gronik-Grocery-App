package com.example.gronik_groceryapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.Fragment.*
import androidx.lifecycle.ViewModelProvider
import com.example.gronik_groceryapp.R
import com.example.gronik_groceryapp.databinding.FragmentHomeBinding
import com.example.gronik_groceryapp.viewmodels.HomeViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.btnCategorySeeAll.setOnClickListener {
            openFragment(CategoryFragment())
        }
        binding.btnOffersSeeAll.setOnClickListener {
            openFragment(OffersFragment())
        }

        binding.fruitsCategory.setOnClickListener {
            openFragment(CategoryFruitsFragments())
        }

//        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
//
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            binding.textHome.text = it
//        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun openFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)  // Or binding.fragmentContainer.id if you're using binding
            .addToBackStack(null) // Optional: adds to back stack
            .commit()
    }

}
