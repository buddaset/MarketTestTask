package com.example.feature_main_screen.presentation.screens.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.precentation.UiState
import com.example.feature_main_screen.domain.model.MainScreenData
import com.example.feature_main_screen.domain.usecase.GetDataMainScreenUseCase
import com.example.feature_main_screen.presentation.mapper.toUi
import com.example.feature_main_screen.presentation.model.BestSellerItemsUi
import com.example.feature_main_screen.presentation.model.HotSalesItemsUi
import com.example.feature_main_screen.presentation.model.MainScreenDataUi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*


internal class ProductViewModel(
    getDataMainScreenUseCase: GetDataMainScreenUseCase,
   ) : ViewModel() {



    @OptIn(ExperimentalCoroutinesApi::class)
    val data: StateFlow<UiState<MainScreenDataUi>> =
        getDataMainScreenUseCase()

            .mapLatest { data -> handleSuccessData(data)  }
            .catch { error -> UiState.Error<MainScreenDataUi>(error = error) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = UiState.Loading()
            )


    private fun handleSuccessData( data: MainScreenData) : UiState.Success<MainScreenDataUi> {
        val  dataUi = MainScreenDataUi(
            bestSeller = BestSellerItemsUi(
                title = "Best Seller",
                bestSellers = data.bestSeller.toUi()) ,

            hotSales = HotSalesItemsUi(
                title = "Hot Sales",
                hotSales = data.hotSales.toUi()
            ))

        return UiState.Success(data = dataUi)
    }




}

