package com.example.shop.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shop.R
import com.example.shop.presenter.BasePresenter
import com.example.shop.presenter.ProfilePresenter
import com.example.shop.view.BaseView
import com.example.shop.view.ProfileView
import moxy.presenter.InjectPresenter

class ProfileFragment : BaseMainNavigationFragment(), ProfileView {

    @InjectPresenter
    override lateinit var presenter: ProfilePresenter

    override fun getLayoutResID(): Int = R.layout.fragment_home

    override fun setupView(savedInstanceState: Bundle?) {
        // do something
    }

}