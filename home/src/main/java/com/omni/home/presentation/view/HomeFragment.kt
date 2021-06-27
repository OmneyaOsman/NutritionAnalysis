package com.omni.home.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.omni.home.R
import com.omni.home.databinding.FragmentHomeBinding
import com.omni.home.presentation.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var _binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        FragmentHomeBinding.inflate(layoutInflater).let {
            _binding = it
        }.also {
            _binding.lifecycleOwner = this
            _binding.viewModel = viewModel
            return _binding.root
        }
    }
}