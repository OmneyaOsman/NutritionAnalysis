package com.omni.summary.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.navGraphViewModels
import com.devexy.summary.R
import com.devexy.summary.databinding.FragmentSummaryBinding
import com.omni.analysis_shared_data.AnalysisSharedViewModel
import com.omni.summary.presentation.viewModel.SummaryViewModel
import com.omni.core.extension.commonObserveViewModelFunctions
import com.omni.summary.presentation.view.adapter.SummaryAdapter
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class SummaryFragment : Fragment(R.layout.fragment_summary) {

    private lateinit var _binding: FragmentSummaryBinding
    private val sharedViewModel: AnalysisSharedViewModel by navGraphViewModels(
        R.id.nav_graph
    )
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeSharedViewModel()

        lifecycleScope.launchWhenStarted {
            viewModel.ingredientEntities.collect {
                Timber.d(it.toString())
                with(_binding.ingredientsRecyclerView) {
                    val summaryAdapter = SummaryAdapter(it)
                    adapter = summaryAdapter
                }
            }
        }
    }

    private fun observeSharedViewModel() {
        sharedViewModel.ingredientEntities.observe(viewLifecycleOwner) {
            viewModel.setIngredientEntities(it)
        }
    }
}