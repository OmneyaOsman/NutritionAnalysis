package com.omni.home.presentation.viewmodel

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
import com.omni.analysis_shared_data.domain.entity.IngredientEntity
import com.omni.core.extension.asyncAll
import com.omni.home.domain.usecase.AnalyzeIngredientsUseCase
import com.omni.home.domain.validation.TextValidation
import com.omni.home.domain.validation.TextValidationRule
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class HomeViewModel(
    private val validationRule: TextValidationRule,
    private val useCase: AnalyzeIngredientsUseCase
) :
    BaseViewModel() {

    private val _isNotActiveToAnalyze = MutableStateFlow(true)

    val isNotActiveToAnalyze: LiveData<Boolean> =
        Transformations.distinctUntilChanged(_isNotActiveToAnalyze.asLiveData())

    val isValidText: SingleLiveEvent<TextValidation?> = SingleLiveEvent()
    private val _result: MutableStateFlow<List<IngredientEntity?>> = MutableStateFlow(emptyList())
    val result = _result.asStateFlow()

    private val _navigateToSummary = MutableStateFlow(false)
    val navigateToSummary = _navigateToSummary.asStateFlow()


    fun setActiveStatus(isActive: Boolean) {
        _isNotActiveToAnalyze.value = isActive
    }

    private val list = mutableListOf<NutritionAnalyzeResponse>()

    private fun getIngredientsDetails(ingredients: List<String>) {
        runBlocking {
            asyncAll(ingredients) { ing ->
                useCase(IngredientRequestModel(ingr = listOf(ing)))
            }.awaitAll().forEach { response ->
                handleResponse(response)
            }
        }
//        ingredients.asFlow() // a flow of requests
//            .map { ing -> useCase(IngredientRequestModel(ingr = listOf(ing))) }.also {
//
//            }
//            .collect { response ->
//                handleResponse(response)
//            }
    }

    fun analyzeIngredients(text: String) {
        isValidText.value = validationRule.validate(text)

        if (isValidText.value == TextValidation.PASSED) {
            val ingredients = text.lines()
            val ingredientsEntities = getIngredientsEntities(ingredients)
            viewModelScope.launch {
                dataLoading.value = true
                getIngredientsDetails(ingredients)
                dataLoading.value = false


                 ingredientsEntities.mapIndexed { index, ingredientEntity ->
                    list[index].let { nutritionAnalyzeResponse ->
                        ingredientEntity.calories = nutritionAnalyzeResponse.calories ?: 0
                        ingredientEntity.weight = nutritionAnalyzeResponse.totalWeight ?: 0
                    }
                }.also {
                     _result.value = ingredientsEntities

                 }
            }
        }
    }

    private fun getIngredientsEntities(ingredients: List<String>): MutableList<IngredientEntity> {
        val ingredientsEntities = mutableListOf<IngredientEntity>()
        ingredients.forEach { ingr ->
            val ingredientEntity = IngredientEntity()
            ingr.split(" ").forEachIndexed { index, s ->
                when (index) {
                    0 -> ingredientEntity.quantity = s
                    1 -> ingredientEntity.unit = s
                    2 -> ingredientEntity.food = s
                }
            }
            ingredientsEntities.add(ingredientEntity)
        }
        return ingredientsEntities
    }

    private suspend fun handleResponse(responseWrapper: ResponseWrapper) {
        when (responseWrapper) {
            is ResponseWrapper.Success<*> -> {
                val successResponse = responseWrapper.data as NutritionAnalyzeResponse
                list.add(successResponse)
//                _result.value = successResponse
//                _navigateToSummary.value = true
            }
            else -> {
                responseWrapper.handleCommonResponses(this@HomeViewModel)
            }
        }
    }
}