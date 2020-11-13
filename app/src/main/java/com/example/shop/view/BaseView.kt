package com.example.shop.view

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface BaseView : MvpView {
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showProgress()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showProgress(message: String)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showProgress(textResId: Int)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun hideProgress()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun toastShort(msg: String)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun toastShort(resId: Int)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun toastLong(msg: String)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun toastLong(resId: Int)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showNoInternetConnectionError()

}