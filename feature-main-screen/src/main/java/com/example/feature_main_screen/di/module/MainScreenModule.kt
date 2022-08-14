package com.example.feature_main_screen.di.module

import com.example.core.di.scope.FeatureScope
import com.example.feature_main_screen.data.remote.api.MainScreenApi
import com.example.feature_main_screen.data.remote.source.MainScreenRemoteDataSource
import com.example.feature_main_screen.data.remote.source.MainScreenRemoteDataSourceImpl
import com.example.feature_main_screen.data.repository.MainScreenRepositoryImpl
import com.example.feature_main_screen.domain.repository.MainScreenRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
interface MainScreenModule {

    @FeatureScope
    @Binds
    fun bindMainScreenRepository(impl: MainScreenRepositoryImpl) : MainScreenRepository


    @Binds
    fun bindMainScreenRemoteDataSource(impl: MainScreenRemoteDataSourceImpl): MainScreenRemoteDataSource





    companion object {

        @Provides
        fun provideMainScreenApi(retrofit: Retrofit) : MainScreenApi =
            retrofit.create(MainScreenApi::class.java)
    }
}