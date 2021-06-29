package com.omni.analysis_shared_data.domain.entity

data class IngredientEntity(
    var quantity: String="",
    var unit: String="",
    var food: String="",
    var calories: Int= 0,
    var weight: Int= 0
)