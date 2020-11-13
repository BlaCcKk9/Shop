package com.example.shop.model.dto

import com.google.gson.annotations.SerializedName

data class WorkingHoursDto(
    @SerializedName("day") var day: String?,
    @SerializedName("from") var from: String?,
    @SerializedName("to") var to: String?,
    @SerializedName("working") var working: Boolean?
)