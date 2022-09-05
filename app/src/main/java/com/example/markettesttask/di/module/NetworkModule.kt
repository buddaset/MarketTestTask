package com.example.markettesttask.di.module

import com.example.core.common.dispatcher.Dispatcher
import com.example.core.common.dispatcher.DispatcherMainUI
import com.example.core.di.scope.ApplicationScope
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import me.sianaki.flowretrofitadapter.FlowCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit

@Module
class NetworkModule {


    @Provides
    @ApplicationScope
    fun provideRetrofit(client: OkHttpClient, converterFactory: Converter.Factory): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addCallAdapterFactory(FlowCallAdapterFactory.create())
            .addConverterFactory(converterFactory)
            .build()


    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @ApplicationScope
    fun provideJsonFactory(): Converter.Factory {
        val json = Json { ignoreUnknownKeys = true }
        return json.asConverterFactory("application/json".toMediaType())
    }

    @Provides
    @ApplicationScope
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(createLoggingInterceptor())
            .build()


    private fun createLoggingInterceptor(): Interceptor =
        HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

    companion object {

        @Provides
        @ApplicationScope
        fun providesDispatcher(): Dispatcher =
            DispatcherMainUI()


        private const val BASE_URL = "https://run.mocky.io/v3/"
    }
}