package com.example.shop.presenter

import com.example.shop.Consts
import com.example.shop.view.MainView
import moxy.InjectViewState

@InjectViewState
class MainPresenter : BasePresenter<MainView>() {

    private var currentTabName: String = ""
        set(value) {
            field = value
        }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        currentTabName = Consts.MainTab.HOME
    }

    fun onHomeSelected() {
        currentTabName = Consts.MainTab.HOME
        viewState.openHomePage()
    }

    fun onOrdersSelected() {
        currentTabName = Consts.MainTab.ORDERS
        viewState.openOrdersPage()
    }

    fun onProfileSelected() {
        currentTabName = Consts.MainTab.PROFILE
        viewState.openProfilePage()
    }

}