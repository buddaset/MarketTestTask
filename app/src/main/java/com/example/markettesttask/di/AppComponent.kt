package com.example.markettesttask.di

import android.content.Context
import com.example.common_tab_bar.di.dependency.TabBarDependencies
import com.example.core.common.dispatcher.Dispatcher
import com.example.core.common.resource_manager.ResourceManager
import com.example.core.di.scope.ApplicationScope
import com.example.feature_main_screen.di.dependency.MainScreenDependencies
import com.example.feature_my_cart.di.dependency.MyCartDependencies
import com.example.feature_product_details.di.dependency.ProductDetailsDependencies
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit


@ApplicationScope
@Component(modules = [NetworkModule::class, CommonModule::class])
interface AppComponent :  MainScreenDependencies, ProductDetailsDependencies, MyCartDependencies, TabBarDependencies {

    override val retrofit: Retrofit
    override val dispatcher: Dispatcher
    override val resourceManager: ResourceManager

    @Component.Factory
    interface Factory{

        fun create(
            @BindsInstance context: Context
        ) : AppComponent
    }
}