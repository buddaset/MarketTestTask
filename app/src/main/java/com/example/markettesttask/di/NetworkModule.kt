package com.example.markettesttask.di

import com.example.core.di.scope.ApplicationScope
import com.example.markettesttask.BuildConfig
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {


    @Provides
    @ApplicationScope
    fun provideRetrofit(client: OkHttpClient, converterFactory: Converter.Factory): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL) //todo change on buildConfig
            .client(client)
            .addConverterFactory(converterFactory)
            .build()


    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @ApplicationScope
    fun provideJsonFactory(): Converter.Factory {
        val json = Json {
            ignoreUnknownKeys = true

        }
        return json.asConverterFactory("application/json".toMediaType())
    }

    @Provides
    @ApplicationScope
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .addInterceptor(createLoggingInterceptor())
            .build()


    private fun createLoggingInterceptor(): Interceptor =
        HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

    companion object {

        private const val BASE_URL = "https://run.mocky.io/v3/"
        private const val TIME_OUT: Long = 10
    }

}