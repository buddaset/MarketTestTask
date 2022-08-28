package com.example.feature_main_screen.presentation.mapper

import com.example.feature_main_screen.domain.model.BestSeller
import com.example.feature_main_screen.domain.model.HotSales
import com.example.feature_main_screen.presentation.model.BestSellerUi
import com.example.feature_main_screen.presentation.model.HotSalesUi


internal fun List<BestSeller>.toUi(): List<BestSellerUi> =
    this.map { bestSeller -> bestSeller.toUi() }


internal fun BestSeller.toUi() =
    BestSellerUi(
        discountPrice = discountPrice,
        id = id,
        isFavorites = isFavorites,
        picture = picture,
        priceWithoutDiscount = priceWithoutDiscount,
        title = title
    )


@JvmName("toUiHotSales")
internal fun List<HotSales>.toUi(): List<HotSalesUi> =
    this.map { hotSales -> hotSales.toUi() }

internal fun HotSales.toUi(): HotSalesUi =
    HotSalesUi(
        id = id,
        isBuy = isBuy,
        isNew = isNew,
        picture = picture,
        subtitle = subtitle,
        title = title
    )





