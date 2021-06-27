package com.omni.home.data.model.response


import com.google.gson.annotations.SerializedName

data class VITB12X(
    @SerializedName("label")
    val label: String?,
    @SerializedName("quantity")
    val quantity: Double?,
    @SerializedName("unit")
    val unit: String?
)