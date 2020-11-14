package com.example.shop.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shop.R
import com.example.shop.adapter.ShopAdapter
import com.example.shop.presenter.HomePresenter
import com.example.shop.view.HomeView
import kotlinx.android.synthetic.main.activity_main.*
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

    override fun printSelectedShopName(shopName: String) {
        Log.d("Shop Name: ", shopName)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

}