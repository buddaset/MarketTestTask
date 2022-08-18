package com.example.markettesttask.di

import com.example.core.di.scope.ApplicationScope
import com.example.feature_main_screen.di.MainScreenDependencies
import dagger.Component
import retrofit2.Retrofit


@ApplicationScope
@Component(modules = [NetworkModule::class])
interface AppComponent : MainScreenDependencies {

    override val retrofit: Retrofit



    @Component.Factory
    interface Factory{

        fun create() : AppComponent
    }
}