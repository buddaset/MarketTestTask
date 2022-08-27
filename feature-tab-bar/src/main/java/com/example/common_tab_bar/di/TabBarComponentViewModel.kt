package com.example.common_tab_bar.di

import androidx.lifecycle.ViewModel
import com.example.common_tab_bar.di.dependency.TabBarDependencies
import kotlin.properties.Delegates
import com.example.common_tab_bar.di.component.DaggerTabBarComponent

class TabBarComponentViewModel : ViewModel() {

    val tabBarComponent =
        DaggerTabBarComponent.factory().create(TabBarDependenciesProvider.dependencies)
}

interface TabBarDependenciesProvider {

    val dependencies: TabBarDependencies

    companion object : TabBarDependenciesProvider by TabBarDependenciesStore


}

object TabBarDependenciesStore: TabBarDependenciesProvider {
    override var dependencies: TabBarDependencies by Delegates.notNull()
}