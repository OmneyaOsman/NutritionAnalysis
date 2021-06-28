package com.omni.home.data.model.response


import com.google.gson.annotations.SerializedName

data class CustomDataClass(
    @SerializedName("label")
    val label: String?= null,
    @SerializedName("quantity")
    val quantity: Double?= null,
    @SerializedName("unit")
    val unit: String?= null
)