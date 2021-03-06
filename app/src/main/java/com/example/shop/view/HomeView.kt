package com.example.shop.view

import com.example.shop.adapter.ShopAdapter
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface HomeView: BaseMainNavigationView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun setupShopsAdapter(adapter: ShopAdapter)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun printSelectedShopName(shopName: String)
}