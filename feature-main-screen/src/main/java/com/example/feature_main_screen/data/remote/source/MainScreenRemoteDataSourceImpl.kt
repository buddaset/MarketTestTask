package com.example.feature_main_screen.data.remote.source

import android.util.Log
import com.example.feature_main_screen.data.remote.api.MainScreenApi
import com.example.feature_main_screen.data.remote.model.MainScreenDataDto
import javax.inject.Inject

internal class MainScreenRemoteDataSourceImpl @Inject constructor(
    private val mainScreenApi: MainScreenApi
) : MainScreenRemoteDataSource {


    override suspend fun loadMainScreenData(): MainScreenDataDto {

         try {
             val result = mainScreenApi.loadMainScreenData()
             Log.d("MainFragment", "source ----$result")
             return result
         }
         catch(e: Throwable) {
             Log.d("MainFragment", "error ----${e.message}")
             throw e
         }

    }

}