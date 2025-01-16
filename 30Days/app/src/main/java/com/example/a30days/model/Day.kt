package com.example.a30days.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Day(
    @StringRes val title : Int,
    @DrawableRes val img : Int,
    @StringRes val descr : Int
)
