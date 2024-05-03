package com.example.cafe.ui.navigation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun SideNavigationBar(
    navController: NavController
) {
    Row(
        modifier = Modifier
            .fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        NavigationRail(
            modifier = Modifier
                .width(100.dp)
                .height(500.dp)
        ) {
            val items = listOf("order", "history", "user", "menu")
            val currentRoute = currentRoute(navController)
            items.forEach { screen ->
                NavigationRailItem(
                    modifier = Modifier.weight(1f),
                    icon = {
                        when (screen) {
                            "order" -> Icon(
                                imageVector = Icons.AutoMirrored.Filled.List,
                                contentDescription = null
                            )

                            "history" -> Icon(
                                imageVector = Icons.Default.DateRange,
                                contentDescription = null
                            )

                            "user" -> Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null
                            )

                            "menu" -> Icon(
                                imageVector = Icons.Default.Menu,
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
}

@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}