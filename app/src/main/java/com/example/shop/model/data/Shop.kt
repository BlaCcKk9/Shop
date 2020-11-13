package com.example.shop.model.data

import com.example.shop.model.dto.ShopDto
import com.example.shop.model.dto.ShopsDto

class Shop {
    var shops: List<Shops> = listOf()

    companion object{
        fun fromDto(dto: ShopDto) = Shop().apply {
            shops = dto.shops?.filterNotNull()?.map { Shops.fromDto(it) } ?: listOf()
        }
    }
}