package com.omni.home.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.omni.analysis_shared_data.AnalysisSharedViewModel
import com.omni.core.extension.commonObserveViewModelFunctions
import com.omni.core.extension.isValidText
import com.omni.core.extension.navigateSafe
import com.omni.home.R
import com.omni.home.databinding.FragmentHomeBinding
import com.omni.home.domain.validation.TextValidation
import com.omni.home.presentation.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber


class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var _binding: FragmentHomeBinding
    private val viewModel by viewModel<HomeViewModel>()
    private val sharedViewModel: AnalysisSharedViewModel by navGraphViewModels(
        R.id.nav_graph
    )

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
            commonObserveViewModelFunctions(viewModel, _binding)

            return _binding.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleTextWatcher()
        handleClickListeners()
        observeViewModel()
    }

    private fun handleTextWatcher() {

        _binding.recipeEditText.setOnFocusChangeListener { _, hasFocus ->
            _binding.recipeEditText.doAfterTextChanged {
                if (hasFocus)
                    viewModel.setActiveStatus(it.toString().isValidText().not())
            }
        }
    }

    private fun handleClickListeners() {
        _binding.analyzeBtn.setOnClickListener {
            viewModel.analyzeIngredients(_binding.recipeEditText.text.toString())
        }
    }

    private fun observeViewModel() {
        viewModel.isValidText.observe(viewLifecycleOwner) { validation ->
            when (validation) {
                TextValidation.EMPTY, TextValidation.IN_VALID -> Toast.makeText(
                    requireContext(),
                    "Please Enter put all ingredient line by line, each line food name, quantity and unit",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.result.collect {
                Timber.d(it.toString())
                it?.let {
                    sharedViewModel.setIngredientEntities(it)
                }
            }
        }

        viewModel.navigateToSummary.observe(viewLifecycleOwner) {
            if (it) {
                findNavController().navigateSafe(R.id.action_HomeFragment_to_SummaryFragment)
            }
        }
    }
}