package com.example.cafe.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.core.R
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun SideNavigationBar(navController: NavController) {
    NavigationRail {
        val items = listOf("home", "base")
        val currentRoute = currentRoute(navController)
        items.forEach { screen ->
            NavigationRailItem(
                modifier = Modifier.weight(1f),
                icon = {
                    when (screen) {
                        "home" -> Icon(
                            Icons.Default.Home,
                            contentDescription = null
                        )

                        "base" -> Image(
                            painter = painterResource(id = R.drawable.ic_call_answer),
                            contentDescription = null
                        )
                    }
                },
                label = { Text(screen) },
                selected = currentRoute == screen,
                onClick = { navigate(screen, navController) }
            )
        }
    }
}

@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}