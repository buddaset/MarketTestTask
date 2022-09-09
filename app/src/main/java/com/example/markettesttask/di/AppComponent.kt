package com.example.markettesttask.di

import android.content.Context
import androidx.room.Database
import com.example.common_tab_bar.di.dependency.TabBarDependencies
import com.example.core.common.dispatcher.Dispatcher
import com.example.core.common.resource_manager.ResourceManager
import com.example.core.di.scope.ApplicationScope
import com.example.feature_main_screen.data.local.dao.MainScreenDataDao
import com.example.feature_main_screen.di.dependency.MainScreenDependencies
import com.example.feature_my_cart.di.dependency.MyCartDependencies
import com.example.feature_product_details.data.local.dao.ProductDetailsDao
import com.example.feature_product_details.di.dependency.ProductDetailsDependencies
import com.example.firebase.MarketFirebaseMessagingService
import com.example.markettesttask.di.module.CommonModule
import com.example.markettesttask.di.module.DatabaseModule
import com.example.markettesttask.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit


@ApplicationScope
@Component(modules = [NetworkModule::class, CommonModule::class, DatabaseModule::class])
interface AppComponent :  MainScreenDependencies, ProductDetailsDependencies, MyCartDependencies, TabBarDependencies {



    fun inject(service: MarketFirebaseMessagingService)

    @Component.Factory
    interface Factory{

        fun create(
            @BindsInstance context: Context
        ) : AppComponent
    }
}