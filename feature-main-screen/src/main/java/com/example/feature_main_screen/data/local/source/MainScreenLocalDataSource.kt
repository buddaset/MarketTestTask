package com.example.feature_main_screen.data.local.source

import com.example.feature_main_screen.data.local.model.MainScreenDataEntityContainer
import kotlinx.coroutines.flow.Flow


interface MainScreenLocalDataSource {



    suspend fun saveData(data: MainScreenDataEntityContainer)


    fun getData() : Flow<MainScreenDataEntityContainer>
}