package ru.testapp.navigation

sealed class NavigationDestination(val destination: String) {
    data object MainScreen: NavigationDestination(destination = Destinations.MAIN_SCREEN.name)
    data object SettingsScreen: NavigationDestination(destination = Destinations.SETTINGS_SCREEN.name)
}