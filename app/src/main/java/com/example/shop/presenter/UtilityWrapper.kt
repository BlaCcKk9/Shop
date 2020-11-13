package com.example.shop.presenter

import android.content.Context
import com.example.shop.App
import com.example.shop.network.RestApi
import javax.inject.Inject

class UtilityWrapper {

    @Inject
    lateinit var applicationContext: Context

    @Inject
    lateinit var restApi: RestApi

    init {
        App.appComponent.inject(this)
    }
}