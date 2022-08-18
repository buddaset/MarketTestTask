package com.example.feature_main_screen.data.remote.api

import com.example.feature_main_screen.data.remote.model.MainScreenDataDto
import retrofit2.http.GET

internal interface MainScreenApi {


    @GET(MAIN_SCREEN_PATH)
   suspend fun loadMainScreenData(): MainScreenDataDto



   companion object {

       const val MAIN_SCREEN_PATH = "654bd15e-b121-49ba-a588-960956b15175"
   }
}