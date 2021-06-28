package com.omni.home.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.devexy.core.livedata.SingleLiveEvent
import com.omni.core.base.BaseViewModel
import com.omni.core.extension.handleCommonResponses
import com.omni.core.wrapper.ResponseWrapper
import com.omni.home.data.model.request.IngredientRequestModel
import com.omni.home.data.model.response.NutritionAnalyzeResponse
import com.omni.home.domain.usecase.AnalyzeIngredientsUseCase
import com.omni.home.domain.validation.TextValidation
import com.omni.home.domain.validation.TextValidationRule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber


class HomeViewModel(
    private val validationRule: TextValidationRule,
    private val useCase: AnalyzeIngredientsUseCase
) :
    BaseViewModel() {

    private val _isNotActiveToAnalyze = MutableStateFlow(true)

    val isNotActiveToAnalyze: LiveData<Boolean> =
        Transformations.distinctUntilChanged(_isNotActiveToAnalyze.asLiveData())

    val isValidText: SingleLiveEvent<TextValidation?> = SingleLiveEvent()
    private val _result: MutableStateFlow<NutritionAnalyzeResponse?> = MutableStateFlow(null)
    val result = _result.asStateFlow()


    fun setActiveStatus(isActive: Boolean) {
        _isNotActiveToAnalyze.value = isActive
    }

    fun analyzeIngredients(text: String) {
        isValidText.value = validationRule.validate(text)

        if (isValidText.value == TextValidation.PASSED) {
            viewModelScope.launch {
                dataLoading.value = true
                val ingredients = text.lines()
                when (val responseWrapper = useCase(IngredientRequestModel(ingr = ingredients))) {
                    is ResponseWrapper.Success<*> -> {
                        val successResponse = responseWrapper.data as NutritionAnalyzeResponse
                        _result.value = successResponse

                    }
                    else -> {
                        responseWrapper.handleCommonResponses(this@HomeViewModel)
                    }
                }

                dataLoading.value = false
            }
        }
    }
}