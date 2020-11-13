package com.example.shop

import android.app.Application
import android.content.Context
import com.example.shop.dagger.component.AppComponent
import com.example.shop.dagger.component.DaggerAppComponent
import com.example.shop.dagger.module.AppModule

class App : Application() {

    companion object {
        lateinit var appContext: Context
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
        configureDagger()
    }

    private fun configureDagger(){
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
        appComponent.inject(this)
    }

}