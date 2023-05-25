package com.example.expressify.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.expressify.R

data class Artikel(
    @DrawableRes val imageArtikel: Int,
    val title: String,
    val date: String,
    val content: String,
)

val dummyArtikel = listOf(
    Artikel(R.drawable.banner_poster,"Marvel ganteng banget buset", "12 Mei 2023", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."),
    Artikel(R.drawable.banner_poster,"Marvel ganteng super buset", "12 Mei 2023", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."),
    Artikel(R.drawable.banner_poster,"Marvel ganteng tolol buset", "12 Mei 2023", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."),
    Artikel(R.drawable.banner_poster,"Marvel ganteng anjay buset", "12 Mei 2023", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."),
    Artikel(R.drawable.banner_poster,"Marvel ganteng keren buset", "12 Mei 2023", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."),
)
