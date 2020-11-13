package com.example.shop.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shop.R
import com.example.shop.presenter.BasePresenter
import com.example.shop.presenter.MainPresenter
import com.example.shop.view.BaseView
import com.example.shop.view.MainView
import moxy.presenter.InjectPresenter

class MainActivity : BaseActivityView(), MainView {

    @InjectPresenter
    override lateinit var presenter: MainPresenter

    override fun getLayoutResID(): Int = R.layout.activity_main

    override fun setupView(savedInstanceState: Bundle?) {

    }

    override fun setupShopsAdapter() {

    }

}