package com.ninhnau.base.common.utils

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class BaseErrorResponse(
    @SerializedName("message")
    val message: JsonElement
    )
