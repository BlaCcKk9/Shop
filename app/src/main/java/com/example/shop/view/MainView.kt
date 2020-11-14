package com.example.shop.view

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface MainView: BaseView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun openHomePage()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun openOrdersPage()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun openProfilePage()
}