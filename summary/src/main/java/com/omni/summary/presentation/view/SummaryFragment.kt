package com.omni.summary.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devexy.summary.R
import com.devexy.summary.databinding.FragmentSummaryBinding
import com.omni.summary.presentation.viewModel.SummaryViewModel
import com.omni.core.extension.commonObserveViewModelFunctions
import org.koin.androidx.viewmodel.ext.android.viewModel

class SummaryFragment : Fragment(R.layout.fragment_summary) {

    private lateinit var _binding: FragmentSummaryBinding
    private val viewModel by viewModel<SummaryViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        FragmentSummaryBinding.inflate(layoutInflater).let {
            _binding = it
        }.also {
            _binding.lifecycleOwner = this
            _binding.viewModel = viewModel
            commonObserveViewModelFunctions(viewModel, _binding)

            return _binding.root
        }
    }
}