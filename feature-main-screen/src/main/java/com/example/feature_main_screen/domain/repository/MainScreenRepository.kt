package com.example.feature_main_screen.domain.repository

import com.example.feature_main_screen.domain.model.MainScreenData

interface MainScreenRepository {


    suspend fun getMainScreenData() : MainScreenData
}