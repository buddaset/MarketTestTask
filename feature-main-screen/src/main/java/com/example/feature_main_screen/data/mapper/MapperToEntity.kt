package com.example.feature_main_screen.data.mapper

import com.example.feature_main_screen.data.local.model.BestSellerEntity
import com.example.feature_main_screen.data.local.model.HotSalesEntity
import com.example.feature_main_screen.data.local.model.MainScreenDataEntityContainer
import com.example.feature_main_screen.data.remote.model.BestSellerDto
import com.example.feature_main_screen.data.remote.model.HotSalesDto
import com.example.feature_main_screen.data.remote.model.MainScreenDataDto


internal fun MainScreenDataDto.toEntity() =
    MainScreenDataEntityContainer(
        bestSeller = bestSeller.toEntity(),
        hotSales = hotSales.toEntity()
    )



@JvmName("toEntityHotSalesDto")
internal fun List<HotSalesDto>.toEntity(): List<HotSalesEntity> =
    this.map { HomeStoreDto -> HomeStoreDto.toEntity() }


internal fun List<BestSellerDto>.toEntity(): List<BestSellerEntity> =
    this.map { bestSellerDto -> bestSellerDto.toEntity() }


internal fun BestSellerDto.toEntity(): BestSellerEntity =
    BestSellerEntity(
        discountPrice = discountPrice,
        id = id,
        isFavorites = isFavorites,
        picture = picture,
        priceWithoutDiscount = priceWithoutDiscount,
        title = title
    )


internal fun HotSalesDto.toEntity(): HotSalesEntity =
    HotSalesEntity(
        id = id,
        isBuy = isBuy,
        isNew = isNew,
        picture = picture,
        subtitle = subtitle,
        title = title
    )




