package com.example.feature_main_screen.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "best_seller_products")
 data class BestSellerEntity(
    @ColumnInfo(name="id") @PrimaryKey val id: Int,
    @ColumnInfo(name="discount_price") val discountPrice: Int,
    @ColumnInfo(name="is_favorites") val isFavorites: Boolean = false,
    @ColumnInfo(name="picture") val picture: String,
    @ColumnInfo(name="price_without_discount") val priceWithoutDiscount: Int,
    @ColumnInfo(name="title") val title: String,

)