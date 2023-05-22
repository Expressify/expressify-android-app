package com.example.expressify.navigation

sealed class Screen (val route: String){
    object Splash: Screen("splash")
    object Home: Screen("home")
    object Jurnal: Screen("jurnal")
    object Moodify: Screen("moodify")
    object Artikel: Screen("artikel")
    object Profil: Screen("profil")
}