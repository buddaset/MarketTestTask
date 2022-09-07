package com.example.feature_main_screen.di.dependency

import com.example.core.common.dispatcher.Dispatcher
import com.example.core.common.resource_manager.ResourceManager
import com.example.feature_main_screen.data.local.dao.MainScreenDataDao
import retrofit2.Retrofit

interface MainScreenDependencies {

    val retrofit: Retrofit
    val dispatcher: Dispatcher
    val resourceManager: ResourceManager
    val mainScreenDataDao: MainScreenDataDao
}