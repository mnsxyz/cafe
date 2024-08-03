package com.example.cafe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.example.cafe.ui.theme.CafeTheme
import com.example.cafe.ui.view.history.History
import com.example.cafe.ui.view.menu.Menu
import com.example.cafe.ui.view.order.Home
import com.example.cafe.ui.view.user.User
import com.example.cafe.vm.CountriesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
//                    Row {
//                        SideNavigationBar(navController)
//                        NavHost(navController, navGraph)
//                    }
                    CountriesList()
                }
            }
        }
    }
}

@Composable
fun CountriesList(viewModel: CountriesViewModel = viewModel()) {
    val countries by viewModel.countries.collectAsState()

    LazyColumn {
        items(
            countries
        ) { country ->
            Text(
                country.name,
                modifier = Modifier.padding(8.dp),
            )
            Text(
                country.time,
                modifier = Modifier.padding(8.dp),
            )
        }
    }
}