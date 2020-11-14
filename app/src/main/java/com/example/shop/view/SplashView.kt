package com.example.shop.view

import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface SplashView : BaseView{
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openMainScreen()
}