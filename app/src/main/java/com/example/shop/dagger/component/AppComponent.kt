package com.example.shop.dagger.component

import com.example.shop.App
import com.example.shop.dagger.module.AppModule
import com.example.shop.presenter.UtilityWrapper
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(app: App)
    fun inject(utilityWrapper: UtilityWrapper)
}