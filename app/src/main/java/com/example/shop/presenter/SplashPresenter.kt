package com.example.shop.presenter

import com.example.shop.view.SplashView
import moxy.InjectViewState

@InjectViewState
class SplashPresenter: BasePresenter<SplashView>() {

    init {
        openStartScreen()
    }

    private fun openStartScreen(){
        viewState.openMainScreen()
    }

}