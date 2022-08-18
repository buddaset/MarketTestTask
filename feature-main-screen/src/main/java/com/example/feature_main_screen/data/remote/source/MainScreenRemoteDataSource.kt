package com.example.feature_main_screen.data.remote.source

import com.example.feature_main_screen.data.remote.model.MainScreenDataDto

internal interface MainScreenRemoteDataSource {

    suspend fun loadMainScreenData(): MainScreenDataDto

}