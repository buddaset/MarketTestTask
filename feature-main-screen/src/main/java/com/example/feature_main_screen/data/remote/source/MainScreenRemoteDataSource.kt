package com.example.feature_main_screen.data.remote.source

import com.example.feature_main_screen.data.remote.model.MainScreenDataDto

interface MainScreenRemoteDataSource {

    suspend fun loadMainScreenData(): MainScreenDataDto

}