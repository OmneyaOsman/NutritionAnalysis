package com.devexy.core.model


import com.google.gson.annotations.SerializedName

data class ServerErrorResponseModel(
    @SerializedName("error") val error: String?
)