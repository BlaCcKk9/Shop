package com.example.shop.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shop.R
import com.example.shop.presenter.BasePresenter
import com.example.shop.presenter.SplashPresenter
import com.example.shop.view.BaseView
import com.example.shop.view.SplashView
import moxy.presenter.InjectPresenter

class SplashActivity : BaseActivityView(), SplashView {

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, SplashActivity::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        }
    }

    @InjectPresenter
    override lateinit var presenter: SplashPresenter

    override fun getLayoutResID(): Int = R.layout.activity_splash

    override fun setupView(savedInstanceState: Bundle?) {

    }

    override fun openMainScreen() {
//        startActivity(MainActivity.createIntent(this))
    }

}