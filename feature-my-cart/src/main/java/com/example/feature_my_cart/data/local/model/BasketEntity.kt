package com.example.feature_my_cart.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "baskets")
data class BasketEntity(
    @PrimaryKey  @ColumnInfo(name="id") val id: Int,
    @ColumnInfo(name="images") val images: String,
    @ColumnInfo(name="price") val price: Int,
    @ColumnInfo(name="title") val title: String
)
