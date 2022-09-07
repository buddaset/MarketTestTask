package com.example.feature_main_screen.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hot_sales_products")
data class HotSalesEntity(
    @ColumnInfo(name="id") @PrimaryKey val id: Int,
    @ColumnInfo(name="is_buy") val isBuy: Boolean = false,
    @ColumnInfo(name="is_new") val isNew: Boolean = false,
    @ColumnInfo(name="picture") val picture: String,
    @ColumnInfo(name="subtitle") val subtitle: String,
    @ColumnInfo(name="title") val title: String ,

)