package com.example.shop.ui

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.example.shop.R
import com.example.shop.presenter.BasePresenter
import com.example.shop.view.BaseView
import com.google.android.material.snackbar.Snackbar
import moxy.MvpAppCompatFragment
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast

abstract class BaseFragmentView : MvpAppCompatFragment(), BaseView {

    abstract val presenter: BasePresenter<out BaseView>

    private var DEFAULT_LOADING_MESSAGE = ""


    private val noInternetConnectionSnackbar by lazy {
        Snackbar.make(
            activity!!.window.decorView.findViewById(android.R.id.content),
            R.string.msg_error_no_internet_connection, Snackbar.LENGTH_LONG
        ).setAction(R.string.settings) { showInternetSettingsScreen() }
    }

    abstract fun getLayoutResID(): Int

    abstract fun setupView(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutResID(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }


    override fun toastShort(msg: String) {
        activity?.toast(msg)
    }

    override fun toastShort(resId: Int) {
        activity?.toast(resId)
    }

    override fun toastLong(msg: String) {
        activity?.longToast(msg)
    }

    override fun toastLong(resId: Int) {
        activity?.longToast(resId)
    }

    override fun showNoInternetConnectionError() {
        if (activity == null) {
            return
        }
        if (!noInternetConnectionSnackbar.isShown)
            noInternetConnectionSnackbar.show()
    }

    private fun showInternetSettingsScreen() {
        startActivity(Intent(Settings.ACTION_WIRELESS_SETTINGS))
    }



}