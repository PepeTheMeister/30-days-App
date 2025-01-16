package com.example.a30days.repository

import com.example.a30days.R
import com.example.a30days.model.Day

object DaysRepository {
    val days = listOf(
        Day(
            title = R.string.title1,
            descr = R.string.desc1,
            img = R.drawable.photo1
        ),
        Day(
            title = R.string.title2,
            descr = R.string.desc2,
            img = R.drawable.photo2
        ),
        Day(
            title = R.string.title3,
            descr = R.string.desc3,
            img = R.drawable.photo3
        ),
        Day(
            title = R.string.title4,
            descr = R.string.desc4,
            img = R.drawable.photo4
        ),
        Day(
            title = R.string.title5,
            descr = R.string.desc5,
            img = R.drawable.photo5
        ),

    )
}