package com.example.cafe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.example.cafe.ui.navigation.SideNavigationBar
import com.example.cafe.ui.theme.CafeTheme
import com.example.cafe.ui.view.history.History
import com.example.cafe.ui.view.menu.Menu
import com.example.cafe.ui.view.order.Home
import com.example.cafe.ui.view.user.User

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CafeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val navGraph = remember(navController) {
                        navController.createGraph(startDestination = "order") {
                            composable("order") { Home() }
                            composable("history") { History() }
                            composable("menu") { Menu() }
                            composable("user") { User() }
                        }
                    }
                    Row {
                        SideNavigationBar(navController)
                        NavHost(navController, navGraph)
                    }
                }
            }
        }
    }

}