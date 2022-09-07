package com.example.feature_product_details.data.local.converter

import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ProductDetailsConverter {

    @TypeConverter
    fun toString(list: List<String>): String {
     return   Json.encodeToString(list)
    }

    @TypeConverter
    fun fromString(value: String): List<String> {
        return Json.decodeFromString(value)

    }
}