package com.example.shop.model.data

import com.example.shop.model.dto.WorkingHoursDto
import com.google.gson.annotations.SerializedName

class WorkingHours {

    var day: String = ""
    var from: String = ""
    var to: String = ""
    var working: Boolean = false

    companion object{
        fun fromDto(dto: WorkingHoursDto) = WorkingHours().apply {
            day = dto.day.orEmpty()
            from = dto.from.orEmpty()
            to = dto.to.orEmpty()
            working = dto.working ?: false
        }
    }
}