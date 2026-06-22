package com.example.flash.data

import android.health.connect.MedicalResourceId
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Item(
    @StringRes val stringResourceId: Int, //Resource identifier for item names
    @StringRes val itemCategoryId: Int, // category of item
    val itemQuantityId: String, //
    val itemPrice: Int,
    @DrawableRes val imageResourceId: Int //drawable image id

)
