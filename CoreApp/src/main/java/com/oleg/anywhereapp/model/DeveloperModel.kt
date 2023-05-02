package com.oleg.anywhereapp.model


import com.google.gson.annotations.SerializedName

data class DeveloperModel(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("url")
    val url: String? = null
)