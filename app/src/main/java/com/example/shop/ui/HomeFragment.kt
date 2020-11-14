package com.example.shop.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shop.R
import com.example.shop.adapter.ShopAdapter
import com.example.shop.presenter.BasePresenter
import com.example.shop.presenter.HomePresenter
import com.example.shop.view.BaseView
import com.example.shop.view.HomeView
import kotlinx.android.synthetic.main.fragment_home.*
import moxy.presenter.InjectPresenter


class HomeFragment : BaseMainNavigationFragment(), HomeView {

    @InjectPresenter
    override lateinit var presenter: HomePresenter

    override fun getLayoutResID(): Int = R.layout.fragment_home

    override fun setupView(savedInstanceState: Bundle?) {
        rvShops.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun setupShopsAdapter(adapter: ShopAdapter) {
        rvShops.adapter = adapter
    }

}