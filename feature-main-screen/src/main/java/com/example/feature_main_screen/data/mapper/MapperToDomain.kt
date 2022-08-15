package com.example.feature_main_screen.data.mapper

import com.example.feature_main_screen.data.remote.model.BestSellerDto
import com.example.feature_main_screen.data.remote.model.HomeStoreDto
import com.example.feature_main_screen.data.remote.model.MainScreenDataDto
import com.example.feature_main_screen.domain.model.BestSeller
import com.example.feature_main_screen.domain.model.HomeStore
import com.example.feature_main_screen.domain.model.MainScreenData


internal fun MainScreenDataDto.toDomain() =
    MainScreenData(
        bestSeller = bestSeller.toDomain(),
        homeStore =  homeStore.toDomain()
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


internal fun HomeStoreDto.toDomain(): HomeStore =
    HomeStore(
        id = id,
        isBuy = isBuy,
        isNew = isNew,
        picture = picture,
        subtitle = subtitle,
        title = title
    )

@JvmName("toDomainHomeStoreDto")
internal fun List<HomeStoreDto>.toDomain(): List<HomeStore> =
    this.map { HomeStoreDto -> HomeStoreDto.toDomain() }


