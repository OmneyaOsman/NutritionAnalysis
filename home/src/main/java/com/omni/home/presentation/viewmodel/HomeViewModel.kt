package com.omni.home.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.omni.core.base.BaseViewModel
import com.omni.home.data.model.request.IngredientRequestModel
import com.omni.home.domain.usecase.AnalyzeIngredientsUseCase
import kotlinx.coroutines.launch


class HomeViewModel (private val useCase: AnalyzeIngredientsUseCase) :
    BaseViewModel() {
        init {
            viewModelScope.launch {
                useCase(IngredientRequestModel(ingr = listOf("150 g Wheat" ,"120 g Mushroom")))
            }
        }
}