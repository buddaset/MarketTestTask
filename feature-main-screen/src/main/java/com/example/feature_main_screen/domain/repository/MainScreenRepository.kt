package com.example.feature_main_screen.domain.repository

import com.example.feature_main_screen.domain.model.MainScreenData
import kotlinx.coroutines.flow.Flow

internal interface MainScreenRepository {


     fun getMainScreenData() : Flow<MainScreenData>
}