package com.example.markettesttask.app

import android.app.Application
import com.example.common_tab_bar.di.TabBarDependenciesStore
import com.example.feature_main_screen.di.MainScreenDependenciesStore
import com.example.feature_my_cart.di.MyCartDependenciesStore
import com.example.feature_product_details.di.ProductDetailsDependenciesStore
import com.example.markettesttask.di.AppComponent
import com.example.markettesttask.di.DaggerAppComponent

class App: Application() {

    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
        ProductDetailsDependenciesStore.dependencies = appComponent
        MainScreenDependenciesStore.dependencies = appComponent
        MyCartDependenciesStore.dependencies = appComponent
        TabBarDependenciesStore.dependencies = appComponent
    }
}