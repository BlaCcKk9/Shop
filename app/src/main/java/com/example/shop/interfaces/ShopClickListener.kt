package com.example.shop.interfaces

import com.example.shop.model.data.Shops

interface ShopClickListener {
    fun onShopClicked(shop: Shops)
}