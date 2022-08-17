package com.example.feature_main_screen.data.mapper

import com.example.feature_main_screen.data.remote.model.BestSellerDto
import com.example.feature_main_screen.data.remote.model.HotSalesDto
import com.example.feature_main_screen.data.remote.model.MainScreenDataDto
import com.example.feature_main_screen.domain.model.BestSeller
import com.example.feature_main_screen.domain.model.HotSales
import com.example.feature_main_screen.domain.model.MainScreenData


internal fun MainScreenDataDto.toDomain() =
    MainScreenData(
        bestSeller = bestSeller.toDomain(),
        hotSales =  hotSales.toDomain()
        )


internal fun BestSellerDto.toDomain() =
    BestSeller(
        discountPrice = discountPrice,
        id = id,
        isFavorites = isFavorites,
        picture = picture,
        priceWithoutDiscount = priceWithoutDiscount,
        title = title
    )

internal fun List<BestSellerDto>.toDomain(): List<BestSeller> =
    this.map { bestSellerDto -> bestSellerDto.toDomain() }


internal fun HotSalesDto.toDomain(): HotSales =
    HotSales(
        id = id,
        isBuy = isBuy,
        isNew = isNew,
        picture = picture,
        subtitle = subtitle,
        title = title
    )

@JvmName("toDomainHomeStoreDto")
internal fun List<HotSalesDto>.toDomain(): List<HotSales> =
    this.map { HomeStoreDto -> HomeStoreDto.toDomain() }


