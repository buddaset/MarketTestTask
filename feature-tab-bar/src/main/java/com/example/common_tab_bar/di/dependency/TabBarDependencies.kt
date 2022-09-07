package com.example.common_tab_bar.di.dependency

import com.example.common_tab_bar.data.local.TabBarDao
import retrofit2.Retrofit

interface TabBarDependencies {

    val retrofit: Retrofit
    val tabBarDao: TabBarDao
}