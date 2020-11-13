package com.example.shop.model.data

import com.example.shop.model.dto.ShopsDto
import com.example.shop.model.dto.WorkingHoursDto

class Shops {

    var id: Int? = -1
    var name: String = ""
    var description: String = ""
    var address: String = ""
    var logoUrl: String = ""
    var backgroundUrl: String = ""
    var orderNo: Int = 0
    var haveService: Boolean = false
    var estimatedTime: String = ""
    var deliveryFee: Double? = null
    var averageRating: Double? = null
    var reviewsCount: Int = 0
    var lowerLimit: Double? = null
    var isActive: Boolean = false
    var workingHours: List<WorkingHours>? = listOf()

    companion object {
        fun fromDto(dto: ShopsDto) = Shops().apply {
            id = dto.id ?: -1
            name = dto.name.orEmpty()
            description = dto.description.orEmpty()
            address = dto.address.orEmpty()
            logoUrl = dto.logoUrl.orEmpty()
            backgroundUrl = dto.backgroundUrl.orEmpty()
            orderNo = dto.orderNo ?: 0
            haveService = dto.haveService ?: false
            estimatedTime = dto.estimatedTime.orEmpty()
            deliveryFee = dto.deliveryFee ?: 0.0
            averageRating = dto.averageRating ?: 0.0
            reviewsCount = dto.reviewsCount ?: 0
            lowerLimit = dto.lowerLimit ?: 0.0
            isActive = dto.isActive ?: false
            workingHours = dto.workingHours?.filterNotNull()?.map { WorkingHours.fromDto(it) } ?: listOf()
        }
    }
}