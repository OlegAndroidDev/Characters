package com.oleg.anywhereapp.model


import com.google.gson.annotations.SerializedName

data class MaintainerModel(
    @SerializedName("github")
    val github: String? = null
)