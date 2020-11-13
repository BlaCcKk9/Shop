package com.example.shop.network.services

import com.example.shop.model.dto.ShopDto
import io.reactivex.Single
import retrofit2.http.GET

interface ShopService {
    @GET("/v1/Shops")
    fun getShops() : Single<ShopDto>
}