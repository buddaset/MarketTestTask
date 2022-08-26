package com.example.common_tab_bar.di.component

import com.example.common_tab_bar.di.dependency.TabBarDependencies
import com.example.common_tab_bar.di.module.TabBarModule
import com.example.common_tab_bar.presentation.screens.tabbar.TabBarFragment
import com.example.core.di.scope.FeatureScope
import dagger.Component

@FeatureScope
@Component(dependencies = [TabBarDependencies::class], modules = [TabBarModule::class])
interface TabBarComponent {

    fun inject(fragment: TabBarFragment)

    @Component.Factory
    interface Factory {

        fun create(
            dependencies: TabBarDependencies
        ): TabBarComponent
    }
}