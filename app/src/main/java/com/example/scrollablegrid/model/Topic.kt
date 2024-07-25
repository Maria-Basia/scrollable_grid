package com.example.scrollablegrid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @DrawableRes val imageResourceID: Int,
    @StringRes val stringResourceID: Int,
    val numberDetail: Int
)
