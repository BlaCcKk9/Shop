package com.example.shop.ui

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.Settings
import com.example.shop.R
import com.example.shop.presenter.BasePresenter
import com.example.shop.view.BaseView
import com.google.android.material.snackbar.Snackbar
import moxy.MvpAppCompatActivity
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast

abstract class BaseActivityView : MvpAppCompatActivity(), BaseView {

    abstract val presenter: BasePresenter<out BaseView>

    abstract fun getLayoutResID(): Int

    abstract fun setupView(savedInstanceState: Bundle?)

    private val noInternetConnectionSnackbar by lazy {
        Snackbar.make(
            window.decorView.findViewById(android.R.id.content),
            R.string.msg_error_no_internet_connection, Snackbar.LENGTH_LONG
        )
            .setAction(R.string.settings) {
                showInternetSettingsScreen()
            }
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResID())
        setupView(savedInstanceState)
    }

    override fun toastShort(msg: String) {
        toast(msg)
    }

    override fun toastShort(resId: Int) {
        toast(resId)
    }

    override fun toastLong(msg: String) {
        longToast(msg)
    }

    override fun toastLong(resId: Int) {
        longToast(resId)
    }

    override fun showNoInternetConnectionError() {
        if (!noInternetConnectionSnackbar.isShown)
            noInternetConnectionSnackbar.show()
    }


    private fun showInternetSettingsScreen() {
        startActivity(Intent(Settings.ACTION_WIRELESS_SETTINGS))
    }
}