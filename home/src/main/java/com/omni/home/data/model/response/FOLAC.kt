package com.omni.home.data.model.response


import com.google.gson.annotations.SerializedName

data class FOLAC(
    @SerializedName("label")
    val label: String?,
    @SerializedName("quantity")
    val quantity: Int?,
    @SerializedName("unit")
    val unit: String?
)