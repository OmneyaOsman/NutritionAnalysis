package com.omni.analysis_shared_data.data.model.response


import com.google.gson.annotations.SerializedName

data class CustomNutritionDataModel(
    @SerializedName("label")
    val label: String?= null,
    @SerializedName("quantity")
    val quantity: Double?= null,
    @SerializedName("unit")
    val unit: String?= null
)