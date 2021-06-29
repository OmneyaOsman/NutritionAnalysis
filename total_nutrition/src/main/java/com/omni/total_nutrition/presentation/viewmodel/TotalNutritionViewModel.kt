package com.omni.total_nutrition.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.devexy.core.livedata.SingleLiveEvent
import com.omni.core.base.BaseViewModel
import com.omni.core.extension.handleCommonResponses
import com.omni.core.wrapper.ResponseWrapper
import com.omni.analysis_shared_data.data.model.request.IngredientRequestModel
import com.omni.analysis_shared_data.data.model.response.NutritionAnalyzeResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

//
//class TotalNutritionViewModel(
//    private val useCase: AnalyzeIngredientsUseCase
//) :
//    BaseViewModel() {
//
//    private val _isNotActiveToAnalyze = MutableStateFlow(true)
//
//    val isNotActiveToAnalyze: LiveData<Boolean> =
//        Transformations.distinctUntilChanged(_isNotActiveToAnalyze.asLiveData())
//
//    private val _result: MutableStateFlow<NutritionAnalyzeResponse?> = MutableStateFlow(null)
//    val result = _result.asStateFlow()
//
//    private val _navigateToSummary = MutableStateFlow(false)
//    val navigateToSummary = _navigateToSummary.asStateFlow()
//
//
//    fun setActiveStatus(isActive: Boolean) {
//        _isNotActiveToAnalyze.value = isActive
//    }
//
//    fun analyzeIngredients(text: String) {
//
//            viewModelScope.launch {
//                dataLoading.value = true
//                val ingredients = text.lines()
//                when (val responseWrapper = useCase(IngredientRequestModel(ingr = ingredients))) {
//                    is ResponseWrapper.Success<*> -> {
//                        val successResponse = responseWrapper.data as NutritionAnalyzeResponse
//                        _result.value = successResponse
//                        _navigateToSummary.value = true
//
//                    }
//                    else -> {
//                        responseWrapper.handleCommonResponses(this@TotalNutritionViewModel)
//                    }
//                }
//
//                dataLoading.value = false
//            }
//        }
//}