package com.example.shop.view

import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface MainView: BaseView {
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun setupShopsAdapter()
}