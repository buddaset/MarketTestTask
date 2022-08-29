package com.example.feature_main_screen.presentation.screens.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.common.resource_manager.ResourceManager
import com.example.core.precentation.UiState
import com.example.feature_main_screen.R
import com.example.feature_main_screen.domain.model.MainScreenData
import com.example.feature_main_screen.domain.usecase.GetDataMainScreenUseCase
import com.example.feature_main_screen.presentation.mapper.toUi
import com.example.feature_main_screen.presentation.model.BestSellerItemsUi
import com.example.feature_main_screen.presentation.model.HotSalesItemsUi
import com.example.feature_main_screen.presentation.model.MainScreenDataUi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*


internal class ProductsViewModel(
    getDataMainScreenUseCase: GetDataMainScreenUseCase,
    private val resourceManager: ResourceManager
   ) : ViewModel() {

    @OptIn(ExperimentalCoroutinesApi::class)
    val data: StateFlow<UiState<MainScreenDataUi>> =
        getDataMainScreenUseCase()
            .mapLatest { data -> handleSuccessData(data)  }
            .catch { error -> UiState.Error(error = error) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = UiState.Loading
            )

    private fun handleSuccessData( data: MainScreenData) : UiState.Success<MainScreenDataUi> {
        val  dataUi = MainScreenDataUi(
            bestSeller = BestSellerItemsUi(
                title = resourceManager.getString(R.string.best_seller_title),
                bestSellers = data.bestSeller.toUi()) ,

            hotSales = HotSalesItemsUi(
                title = resourceManager.getString(R.string.hot_sales_title),
                hotSales = data.hotSales.toUi()
            ))

        return UiState.Success(data = dataUi)
    }

}

