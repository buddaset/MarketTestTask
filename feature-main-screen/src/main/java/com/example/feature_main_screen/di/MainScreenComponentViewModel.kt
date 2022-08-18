package com.example.feature_main_screen.di

import androidx.lifecycle.ViewModel
import com.example.feature_main_screen.di.component.DaggerMainScreenComponent
import kotlin.properties.Delegates

internal class MainScreenComponentViewModel : ViewModel() {

    val mainScreenComponent =
        DaggerMainScreenComponent.factory().create(MainScreenDependenciesProvider.dependencies)
}

interface MainScreenDependenciesProvider {

    val dependencies: MainScreenDependencies

    companion object : MainScreenDependenciesProvider by MainScreenDependenciesStore
}

object MainScreenDependenciesStore: MainScreenDependenciesProvider {

    override var dependencies: MainScreenDependencies by Delegates.notNull()

}