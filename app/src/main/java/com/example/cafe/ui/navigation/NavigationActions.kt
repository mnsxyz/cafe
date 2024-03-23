package com.example.cafe.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController

object Route {
    const val HOME = "Home"
    const val BASE = "Base"
}

data class TopLevelDestination(
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int
)

fun navigate(screen: String, navController: NavController) {
    navController.navigate(screen) {
        popUpTo(navController.graph.startDestinationId) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}