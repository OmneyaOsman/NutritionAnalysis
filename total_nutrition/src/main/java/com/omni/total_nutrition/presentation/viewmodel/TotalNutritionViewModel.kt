package com.omni.total_nutrition.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.omni.core.base.BaseViewModel
import com.omni.core.extension.handleCommonResponses
import com.omni.core.wrapper.ResponseWrapper
import com.omni.analysis_shared_data.data.model.request.IngredientRequestModel
import com.omni.analysis_shared_data.data.model.response.NutritionAnalyzeResponse
import com.omni.analysis_shared_data.domain.usecase.AnalyzeIngredientsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class TotalNutritionViewModel(
    private val useCase: AnalyzeIngredientsUseCase
) :
    BaseViewModel() {

    private val _result: MutableStateFlow<NutritionAnalyzeResponse?> = MutableStateFlow(null)
    val result = _result.asStateFlow()


    fun analyzeIngredients(ingredients: List<String>) {

        viewModelScope.launch {
            dataLoading.value = true
            when (val responseWrapper = useCase(IngredientRequestModel(ingr = ingredients))) {

                is ResponseWrapper.Success<*> -> {
                    val successResponse = responseWrapper.data as NutritionAnalyzeResponse
                    _result.value = successResponse

                }
                else -> {
                    responseWrapper.handleCommonResponses(this@TotalNutritionViewModel)
                }
            }
        }
        dataLoading.value = false

    }
}