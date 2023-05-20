package com.example.expressify

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.expressify.navigation.Screen
import com.example.expressify.ui.splash.SplashScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpressifyApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
){
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Splash.route,
            modifier = modifier.padding(innerPadding),
        ){
            composable(Screen.Splash.route){
                SplashScreen(
                    navigateNext = {
                        navController.popBackStack()
                        navController.navigate(Screen.Home.route)
                    }
                )
            }

            composable(Screen.Home.route){

            }

        }

    }
}