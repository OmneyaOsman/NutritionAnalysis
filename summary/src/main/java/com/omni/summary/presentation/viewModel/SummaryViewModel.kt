package com.omni.summary.presentation.viewModel

import com.omni.analysis_shared_data.domain.entity.IngredientEntity
import com.omni.core.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SummaryViewModel : BaseViewModel() {

    private val _ingredientEntities = MutableStateFlow<List<IngredientEntity>>(emptyList())
    val ingredientEntities = _ingredientEntities.asStateFlow()


     fun setIngredientEntities(list: List<IngredientEntity>) {
        _ingredientEntities.value = list
    }
}