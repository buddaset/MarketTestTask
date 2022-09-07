package com.example.feature_my_cart.di.module

import com.example.core.di.scope.FeatureScope
import com.example.feature_my_cart.data.local.source.MyCartLocalDataSource
import com.example.feature_my_cart.data.local.source.MyCartLocalDataSourceImpl
import com.example.feature_my_cart.data.remote.api.CartApi
import com.example.feature_my_cart.data.remote.source.MyCartRemoteDataSource
import com.example.feature_my_cart.data.remote.source.MyCartRemoteDataSourceImpl
import com.example.feature_my_cart.data.repository.MyCartRepositoryImpl
import com.example.feature_my_cart.domain.repository.MyCartRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
internal interface MyCartModule {


    @Binds
    @FeatureScope
    fun bindMyCartRepository(impl: MyCartRepositoryImpl): MyCartRepository

    @Binds
    fun bindMyCartRemoteDataSource(impl: MyCartRemoteDataSourceImpl) : MyCartRemoteDataSource

    @Binds
    fun bindMyCartLocalDataSource(impl: MyCartLocalDataSourceImpl) : MyCartLocalDataSource

    companion object {

        @Provides
        fun provideCartApi(retrofit: Retrofit) : CartApi =
            retrofit.create(CartApi::class.java)
    }
}