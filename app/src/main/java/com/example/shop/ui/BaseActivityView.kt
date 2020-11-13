package com.example.shop.ui

import com.example.shop.presenter.BasePresenter
import com.example.shop.view.BaseView
import moxy.MvpAppCompatActivity

abstract class BaseActivityView : MvpAppCompatActivity(), BaseView {

    abstract val presenter: BasePresenter<out BaseView>
}