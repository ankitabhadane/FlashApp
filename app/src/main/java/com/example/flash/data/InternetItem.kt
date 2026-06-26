package com.example.flash.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InternetItem(
    @SerialName("stringResourceId") val itemName: String,
    @SerialName("itemCategoryId") val itemCategory: String,
    @SerialName("itemQuantity") val itemQuality: String,
    @SerialName("item_price") val itemPrice: Int,
    @SerialName("imageResourceId") val itemUrl: String
)
