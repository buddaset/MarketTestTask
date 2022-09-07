package com.example.feature_my_cart.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "cards")
data class CartEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @Ignore val basket: List<BasketEntity>,
    @ColumnInfo(name = "delivery") val delivery: String,
    @ColumnInfo(name = "total") val total: Int
){

    constructor(id: String, delivery: String, total: Int) : this(id, emptyList(), delivery, total)
}
