package com.example.feature_main_screen.data.local.model


data class MainScreenDataEntityContainer(
     val bestSeller: List<BestSellerEntity>,
     val hotSales: List<HotSalesEntity>
)


fun MainScreenDataEntityContainer.isEmpty() =
     hotSales.isEmpty() || bestSeller.isEmpty()


