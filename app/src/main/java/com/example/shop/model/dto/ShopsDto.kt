package com.example.shop.model.dto

import com.google.gson.annotations.SerializedName

data class ShopsDto(
    @SerializedName("id") var id: Int?,
    @SerializedName("name") var name: String?,
    @SerializedName("description") var description: String?,
    @SerializedName("address") var address: String?,
    @SerializedName("logoUrl") var logoUrl: String?,
    @SerializedName("backgroundUrl") var backgroundUrl: String?,
    @SerializedName("orderNo") var orderNo: Int?,
    @SerializedName("haveService") var haveService: Boolean?,
    @SerializedName("estimatedTime") var estimatedTime: String?,
    @SerializedName("deliveryFee") var deliveryFee: Double?,
    @SerializedName("averageRating") var averageRating: Double?,
    @SerializedName("reviewsCount") var reviewsCount: Int?,
    @SerializedName("lowerLimit") var lowerLimit: Double?,
    @SerializedName("isActive") var isActive: Boolean?,
    @SerializedName("workingHours") var workingHours: List<WorkingHoursDto>?

)