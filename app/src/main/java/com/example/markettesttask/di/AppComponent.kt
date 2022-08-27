package com.example.markettesttask.di

import com.example.common_tab_bar.di.dependency.TabBarDependencies
import com.example.core.di.scope.ApplicationScope
import com.example.feature_main_screen.di.dependency.MainScreenDependencies
import com.example.feature_my_cart.di.dependency.MyCartDependencies
import com.example.feature_product_details.di.dependency.ProductDetailsDependencies
import dagger.Component
import retrofit2.Retrofit


@ApplicationScope
@Component(modules = [NetworkModule::class])
interface AppComponent : ProductDetailsDependencies, MainScreenDependencies, MyCartDependencies, TabBarDependencies {

    override val retrofit: Retrofit



    @Component.Factory
    interface Factory{

        fun create() : AppComponent
    }
}