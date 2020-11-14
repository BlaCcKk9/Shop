package com.example.shop.presenter

import android.text.TextUtils
import android.widget.Toast
import com.example.shop.R
import com.example.shop.network.error_handling.ApiErrorListener
import com.example.shop.network.error_handling.HttpError
import com.example.shop.network.error_handling.handleNetworkError
import com.example.shop.ui.MainActivity
import com.example.shop.view.BaseView
import io.reactivex.disposables.CompositeDisposable
import moxy.MvpPresenter
import org.jetbrains.anko.internals.AnkoInternals.createIntent
import org.jetbrains.anko.internals.AnkoInternals.internalStartActivity

abstract class BasePresenter<T : BaseView> : MvpPresenter<T>(), ApiErrorListener {

    private var utilityWrapper: UtilityWrapper = UtilityWrapper()

    val subscription: CompositeDisposable = CompositeDisposable()

    fun restApi() = utilityWrapper.restApi

    fun applicationContext() = utilityWrapper.applicationContext

    private var isResume: Boolean = false
    private var isOpenNewScreenFlow = false


    override fun onFirstViewAttach() {
//        if (!isOpenNewScreenFlow) {
//            isOpenNewScreenFlow = true
//            viewState.openSplashScreen()
//        }
//        openMainScreen()
    }

    override fun onDestroy() {
        subscription.dispose()
        super.onDestroy()
    }


    override fun onHttpError(error: HttpError) {
        when {
            error.isUnauthorized() -> {
                viewState.toastShort(R.string.network_error_unauthorized)
            }
            error.isServerError() -> {
                viewState.toastShort(R.string.network_error_server)
            }
            !TextUtils.isEmpty(error.message) -> {
                viewState.toastShort(error.message!!)
            }
        }
    }

    override fun onNoInternetConnection() {
        viewState.showNoInternetConnectionError()
    }

    override fun onGenericError(t: Throwable?) {
        if (t != null && t.localizedMessage != null) {
            viewState.toastLong(t.localizedMessage.orEmpty())
        }
    }

    override fun onHttpErrors(errors: Collection<HttpError>) {
        var msg = ""
        errors.map { it.message }
            .forEach {
                msg += it
            }

        if (!TextUtils.isEmpty(msg)) {
            viewState.toastLong(msg)
        }
    }

    open fun onResume() {
        isResume = true
    }

    open fun onPause() {
        isResume = false
    }

    open fun handleError(t: Throwable?) {
//        viewState.hideProgress()
        t?.printStackTrace()
        handleNetworkError(applicationContext(), t, this)
    }

    private fun openMainScreen(){
        if (!isOpenNewScreenFlow) {
            isOpenNewScreenFlow = true
            viewState.openSplashScreen()
        }
    }



}