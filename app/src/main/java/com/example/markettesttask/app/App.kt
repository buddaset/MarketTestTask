package com.example.markettesttask.app

import android.app.Application
import com.example.feature_main_screen.di.MainScreenDependenciesStore
import com.example.markettesttask.di.AppComponent
import com.example.markettesttask.di.DaggerAppComponent

class App: Application() {

    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create()
    }

    override fun onCreate() {
        super.onCreate()
        MainScreenDependenciesStore.dependencies = appComponent
    }
}