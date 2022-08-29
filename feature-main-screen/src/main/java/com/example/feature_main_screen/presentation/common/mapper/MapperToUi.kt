package com.example.feature_main_screen.presentation.common.mapper

import com.example.feature_main_screen.domain.model.BestSeller
import com.example.feature_main_screen.domain.model.HotSales
import com.example.feature_main_screen.presentation.common.model.BestSellerUi
import com.example.feature_main_screen.presentation.common.model.HotSalesUi
import java.text.DecimalFormat


internal fun List<BestSeller>.toUi(): List<BestSellerUi> =
    this.map { bestSeller -> bestSeller.toUi() }


internal fun BestSeller.toUi() =
    BestSellerUi(
        discountPrice = formatPrice(discountPrice),
        id = id,
        isFavorites = isFavorites,
        picture = picture,
        priceWithoutDiscount = formatPrice(priceWithoutDiscount),
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


internal fun formatPrice(price: Int): String =
     "$${DecimalFormat("#,###").format(price)}"



