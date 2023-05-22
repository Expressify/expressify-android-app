package com.example.expressify.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.expressify.R

data class Artikel(
    @DrawableRes val imageArtikel: Int,
    val title: String,
    val date: String,
)

val dummyArtikel = listOf(
    Artikel(R.drawable.banner_poster,"Marvel ganteng banget buset", "12 Mei 2023"),
    Artikel(R.drawable.banner_poster,"Marvel ganteng super buset", "12 Mei 2023"),
    Artikel(R.drawable.banner_poster,"Marvel ganteng tolol buset", "12 Mei 2023"),
    Artikel(R.drawable.banner_poster,"Marvel ganteng anjay buset", "12 Mei 2023"),
    Artikel(R.drawable.banner_poster,"Marvel ganteng keren buset", "12 Mei 2023"),
)
