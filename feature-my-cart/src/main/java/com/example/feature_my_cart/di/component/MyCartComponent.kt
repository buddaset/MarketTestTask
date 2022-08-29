package com.example.feature_my_cart.di.component

import com.example.core.di.scope.FeatureScope
import com.example.feature_my_cart.di.dependency.MyCartDependencies
import com.example.feature_my_cart.di.module.MyCartModule
import com.example.feature_my_cart.presentation.screens.mycart.MyCartFragment
import dagger.Component


@FeatureScope
@Component(dependencies = [MyCartDependencies::class], modules = [MyCartModule::class])
internal interface MyCartComponent {


    fun inject(fragment: MyCartFragment)

    @Component.Factory
    interface Factory {

        fun create(
            dependencies: MyCartDependencies
        ): MyCartComponent
    }
}