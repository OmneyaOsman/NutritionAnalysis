package com.omni.total_nutrition.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.omni.total_nutrition.R
import com.omni.total_nutrition.databinding.FragmentTotalNutritionBinding

class TotalNutritionFragment : Fragment(R.layout.fragment_total_nutrition) {
    private lateinit var _binding: FragmentTotalNutritionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        FragmentTotalNutritionBinding.inflate(layoutInflater).let {
            _binding = it
        }.also {
            return _binding.root
        }
    }
}