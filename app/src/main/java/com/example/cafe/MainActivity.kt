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
import com.example.cafe.ui.base.Base
import com.example.cafe.ui.home.Home
import com.example.cafe.ui.navigation.SideNavigationBar
import com.example.cafe.ui.theme.CafeTheme

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
                        navController.createGraph(startDestination = "home") {
                            composable("home") { Home(navController) }
                            composable("base") { Base(navController) }
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