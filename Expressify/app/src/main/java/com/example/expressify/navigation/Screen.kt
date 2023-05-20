package com.example.expressify.navigation

sealed class Screen (val route: String){
    object Splash: Screen("splash")
    object Home: Screen("home")
}