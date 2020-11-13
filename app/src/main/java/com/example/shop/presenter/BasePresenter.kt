package com.example.shop.presenter

import com.example.shop.view.BaseView
import io.reactivex.disposables.CompositeDisposable
import moxy.MvpPresenter

class BasePresenter<T : BaseView> : MvpPresenter<T>() {

    private var utilityWrapper: UtilityWrapper = UtilityWrapper()

    val subscription: CompositeDisposable = CompositeDisposable()

    fun restApi() = utilityWrapper.restApi

    fun applicationContext() = utilityWrapper.applicationContext




}