package com.example.feature_main_screen.di.component

import com.example.core.di.scope.FeatureScope
import com.example.feature_main_screen.di.MainScreenDependencies
import com.example.feature_main_screen.di.module.MainScreenModule
import com.example.feature_main_screen.presentation.screens.main.MainFragment
import dagger.Component


@FeatureScope
@Component(dependencies = [MainScreenDependencies::class] , modules = [MainScreenModule::class])
internal interface MainScreenComponent {

    fun inject(fragment: MainFragment)

    @Component.Factory
    interface Factory {

        fun create(
            dependencies: MainScreenDependencies): MainScreenComponent
    }
}