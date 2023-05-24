package com.example.expressify

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.expressify.navigation.NavigationItem
import com.example.expressify.navigation.Screen
import com.example.expressify.ui.screen.home.HomeScreen
import com.example.expressify.ui.screen.jurnal.JurnalScreen
import com.example.expressify.ui.screen.splash.SplashScreen
import com.example.expressify.ui.theme.ExpressifyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpressifyApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(bottomBar = {
        if (currentRoute != Screen.Splash.route) {
            BottomBar(navController = navController)
        }
    },
        topBar = {
            if (currentRoute != Screen.Splash.route) {
                TopBar()
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Splash.route,
            modifier = modifier.padding(innerPadding),
        ) {
            composable(Screen.Splash.route) {
                SplashScreen(
                    navigateNext = {
                        navController.popBackStack()
                        navController.navigate(Screen.Home.route)
                    }
                )
            }

            composable(Screen.Home.route) {
                HomeScreen()
            }

            composable(Screen.Jurnal.route){
                JurnalScreen(tambahJurnal = {})
            }

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Image(
                painter = painterResource(id = R.drawable.logo_banner_transparant),
                contentDescription = "banner",
                modifier = Modifier.size(120.dp)
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Preview
@Composable
fun TopBarPreview() {
    ExpressifyTheme {
        TopBar()
    }
}

@Composable
fun BottomBar(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    NavigationBar(modifier = modifier) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navigatiomItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_home),
                icon = Icons.Default.Home,
                screen = Screen.Home,
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_jurnal),
                icon = Icons.Default.Assignment,
                screen = Screen.Jurnal,
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_moodify),
                icon = Icons.Default.CameraAlt,
                screen = Screen.Moodify,
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_artikel),
                icon = Icons.Default.LibraryBooks,
                screen = Screen.Artikel,
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_profil),
                icon = Icons.Default.AccountCircle,
                screen = Screen.Profil,
            ),
        )
        NavigationBar {
            navigatiomItems.map { item ->
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                        )
                    },
                    label = { Text(item.title) },
                    selected = currentRoute == item.screen.route,
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = MaterialTheme.colorScheme.tertiary
                    ),
                    onClick = {
                        navController.navigate(item.screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}