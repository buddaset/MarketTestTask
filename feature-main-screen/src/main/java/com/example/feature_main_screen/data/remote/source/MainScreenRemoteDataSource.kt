package com.example.feature_main_screen.data.remote.source

import com.example.feature_main_screen.data.remote.model.MainScreenDataDto
import kotlinx.coroutines.flow.Flow

internal interface MainScreenRemoteDataSource {

     fun loadMainScreenData(): Flow<MainScreenDataDto>

}