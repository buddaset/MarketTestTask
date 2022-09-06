package com.example.feature_product_details.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "product_details")
data class ProductDetailsEntity(
    @PrimaryKey  @ColumnInfo(name="id")  val id: String,
    @ColumnInfo(name="cpu") val CPU: String,
    @ColumnInfo(name="camera") val camera: String,
    @ColumnInfo(name="capacity")  val capacity: List<String>,
    @ColumnInfo(name="color")  val color: List<String>,
    @ColumnInfo(name="images") val images: List<String>,
    @ColumnInfo(name="is_favorites")  val isFavorites: Boolean,
    @ColumnInfo(name="price") val price: Int,
    @ColumnInfo(name="rating")  val rating: Double,
    @ColumnInfo(name="sd") val sd: String,
    @ColumnInfo(name="ssd")  val ssd: String,
    @ColumnInfo(name="title")  val title: String
)
