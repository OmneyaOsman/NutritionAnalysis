package com.omni.home.data.model.response


import com.google.gson.annotations.SerializedName

data class CHOLE(
    @SerializedName("label")
    val label: String?,
    @SerializedName("quantity")
    val quantity: Int?,
    @SerializedName("unit")
    val unit: String?
)