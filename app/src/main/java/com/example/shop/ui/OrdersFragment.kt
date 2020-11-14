package com.example.shop.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.shop.R
import com.example.shop.presenter.BasePresenter
import com.example.shop.presenter.OrdersPresenter
import com.example.shop.view.BaseView
import com.example.shop.view.OrdersView
import moxy.presenter.InjectPresenter


class OrdersFragment : BaseMainNavigationFragment(), OrdersView {

    @InjectPresenter
    override lateinit var presenter: OrdersPresenter

    override fun getLayoutResID(): Int = R.layout.fragment_orders

    override fun setupView(savedInstanceState: Bundle?) {
        // do something
    }

}