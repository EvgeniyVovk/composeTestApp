package ru.testapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.testapp.main_screen.presentation.composable.MainScreen
import ru.testapp.settings.presentation.composable.SettingsScreen

@Composable
fun NavHostApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationDestination.MainScreen.destination
    ) {
        composable(NavigationDestination.MainScreen.destination) {
            MainScreen {
                navController.navigate(
                    NavigationDestination.SettingsScreen.destination
                )
            }
        }
        composable(NavigationDestination.SettingsScreen.destination) {
            SettingsScreen {
                navController.navigate(
                    NavigationDestination.MainScreen.destination
                )
            }
        }
    }
}