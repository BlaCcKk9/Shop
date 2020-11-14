package com.example.shop.presenter

import android.widget.Toast
import com.example.shop.interfaces.ShopClickListener
import com.example.shop.adapter.ShopAdapter
import com.example.shop.model.data.Shop
import com.example.shop.model.data.Shops
import com.example.shop.view.HomeView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState

@InjectViewState
class HomePresenter : BaseMainNavigationPresenter<HomeView>(), ShopClickListener {

    private var shopsAdapter: ShopAdapter? = null
        set(value) {
            field = value
            viewState.setupShopsAdapter(field!!)
        }

    init {
        loadShops()
    }

    private fun loadShops(){
        restApi().shopService
            .getShops()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    onSuccessLoadShops(Shop.fromDto(it))
                },
                onError = {
                    handleError(it)
                }
            )
    }

    private fun onSuccessLoadShops(shop: Shop){
        shopsAdapter = ShopAdapter(shop.shops, this)
    }

    override fun onShopClicked(shop: Shops) {
        Toast.makeText(applicationContext(), shop.name, Toast.LENGTH_SHORT).show()
    }
}