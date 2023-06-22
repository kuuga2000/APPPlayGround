package com.example.beautiful_apps.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.beautiful_apps.R

data class Rider(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    val age: Int,
    @StringRes val skills: Int
)

val riders = listOf(
    Rider(R.drawable.axel, R.string.kr_1, 20, R.string.kr_description_1),
    Rider(R.drawable.black, R.string.kr_2, 20, R.string.kr_description_2),
    Rider(R.drawable.blade, R.string.kr_3, 20, R.string.kr_description_3),
    Rider(R.drawable.fang_joker, R.string.kr_4, 20, R.string.kr_description_4),
    Rider(R.drawable.zeroone, R.string.kr_5, 20, R.string.kr_description_5),
    Rider(R.drawable.zio, R.string.kr_6, 20, R.string.kr_description_6),
    Rider(R.drawable.fourze, R.string.kr_7, 20, R.string.kr_description_7),
    Rider(R.drawable.build, R.string.kr_8, 20, R.string.kr_description_8),
    Rider(R.drawable.heat_metal, R.string.kr_9, 20, R.string.kr_description_9),
    Rider(R.drawable.ichigo_nigo, R.string.kr_10, 20, R.string.kr_description_10),
    Rider(R.drawable.vulcan, R.string.kr_11, 20, R.string.kr_description_11)
)