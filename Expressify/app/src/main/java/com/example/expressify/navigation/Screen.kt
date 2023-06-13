package com.example.expressify.navigation

sealed class Screen (val route: String){
    object Splash: Screen("splash")
    object Home: Screen("home")
    object Jurnal: Screen("jurnal")
    object Moodify: Screen("moodify")
    object Artikel: Screen("artikel")
    object Profil: Screen("profil")
    object Login: Screen("login")
    object Register: Screen("register")
    object Camera: Screen("camera")
    object DetailArtikel: Screen("detail/{artikelId}"){
        fun createRoute(artikelId: Long) = "detail/$artikelId"
    }
}

val routeWithoutTopBar = listOf(
    Screen.Splash.route,
    Screen.Login.route,
    Screen.Register.route,
    Screen.Camera.route,
    Screen.DetailArtikel.route
)