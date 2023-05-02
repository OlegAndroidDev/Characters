package com.oleg.anywhereapp.model


import com.google.gson.annotations.SerializedName

data class IconModel(
    @SerializedName("Height")
    val height: String? = null,
    @SerializedName("URL")
    val uRL: String? = null,
    @SerializedName("Width")
    val width: String? = null
)