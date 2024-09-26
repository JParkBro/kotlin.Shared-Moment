package jpark.bro.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import jpark.bro.presentation.ui.screen.CalendarScreen
import jpark.bro.presentation.ui.screen.HomeScreen
import jpark.bro.presentation.ui.screen.SettingsScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = NavItem.Home.route,
        modifier = modifier
    ) {
        composable(NavItem.Home.route) { HomeScreen(navHostController = navController) }
        composable(NavItem.Calendar.route) { CalendarScreen(navHostController = navController) }
        composable(NavItem.Settings.route) { SettingsScreen(navHostController = navController) }
    }
}