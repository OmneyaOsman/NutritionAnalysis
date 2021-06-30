package com.omni.total_nutrition.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.navGraphViewModels
import com.omni.analysis_shared_data.AnalysisSharedViewModel
import com.omni.analysis_shared_data.data.model.response.CustomNutritionDataModel
import com.omni.analysis_shared_data.data.model.response.TotalDaily
import com.omni.core.extension.commonObserveViewModelFunctions
import com.omni.total_nutrition.R
import com.omni.total_nutrition.databinding.FragmentTotalNutritionBinding
import com.omni.total_nutrition.presentation.viewmodel.TotalNutritionViewModel
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class TotalNutritionFragment : Fragment(R.layout.fragment_total_nutrition) {
    private lateinit var _binding: FragmentTotalNutritionBinding
    private val viewModel by viewModel<TotalNutritionViewModel>()
    private val sharedViewModel: AnalysisSharedViewModel by navGraphViewModels(
        R.id.nav_graph
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        FragmentTotalNutritionBinding.inflate(layoutInflater).let {
            _binding = it
            _binding.lifecycleOwner = this
            _binding.viewModel = viewModel
            commonObserveViewModelFunctions(viewModel, _binding)

        }.also {
            return _binding.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeSharedViewModel()
        observeTotalNutritionViewModel()
    }

    private fun observeTotalNutritionViewModel() {
        lifecycleScope.launchWhenStarted {
            viewModel.result.collect {
                _binding.value.text = it?.calories.toString()
                it?.totalDaily?.let { totalDaily ->
                    val list = getTotalDailyList(totalDaily)
                    _binding.totalNutritionRecyclerview.adapter =
                        TotalNutritionAdapter(list)
                }
            }
        }
    }

    private fun getTotalDailyList(totalDaily: TotalDaily): MutableList<CustomNutritionDataModel> {
        val list = mutableListOf<CustomNutritionDataModel>()
        with(totalDaily) {
            cA?.let { item ->
                list.add(item)
            }
            cHOCDF?.let { item ->
                list.add(item)
            }
            cHOLE?.let { item ->
                list.add(item)
            }
            vITK1?.let { item ->
                list.add(item)
            }
            vITD?.let { item ->
                list.add(item)
            }
            vITC?.let { item ->
                list.add(item)
            }
            vITB6A?.let { item ->
                list.add(item)
            }
            vITARAE?.let { item ->
                list.add(item)
            }
            vITB12?.let { item ->
                list.add(item)
            }
            fAT?.let { item ->
                list.add(item)
            }
            fASAT?.let { item ->
                list.add(item)
            }
            fOLDFE?.let { item ->
                list.add(item)
            }
            fIBTG?.let { item ->
                list.add(item)
            }
            nA?.let { item ->
                list.add(item)
            }
            k?.let { item ->
                list.add(item)
            }
            pROCNT?.let { item ->
                list.add(item)
            }
            p?.let { item ->
                list.add(item)
            }
        }
        return list
    }

    private fun observeSharedViewModel() {
        sharedViewModel.ingredientRequestModel.observe(viewLifecycleOwner) {
            viewModel.analyzeIngredients(it)
        }
    }
}