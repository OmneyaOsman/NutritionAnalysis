package com.omni.home.data.model.request

import com.google.gson.annotations.SerializedName

data class IngredientRequestModel(
    @SerializedName("title") var title: String? = null,
    @SerializedName("ingr") var ingr: List<String>,
    @SerializedName("url") var url: String? = null,
    @SerializedName("summary") var summary: String? = null,
    @SerializedName("yield") var yield: String? = null,
    @SerializedName("time") var time: String? = null,
    @SerializedName("img") var img: String? = null,
    @SerializedName("prep") var prep: String? = null,
    @SerializedName("cuisine") var cuisine: String? = null,
    @SerializedName("mealtype") var mealtype: String? = null,
    @SerializedName("dishtype") var dishtype: String? = null,
)