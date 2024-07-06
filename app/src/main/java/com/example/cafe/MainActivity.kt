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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.example.cafe.data.OrderDetail
import com.example.cafe.ui.theme.CafeTheme
import com.example.cafe.ui.view.history.History
import com.example.cafe.ui.view.menu.Menu
import com.example.cafe.ui.view.order.Home
import com.example.cafe.ui.view.user.User
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

val supabase = createSupabaseClient(
    supabaseUrl = BuildConfig.SUPA_URL,
    supabaseKey = BuildConfig.SUPA_KEY
) {
    install(Postgrest)
}

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
fun CountriesList() {
    var countries by remember { mutableStateOf<List<OrderDetail>>(listOf()) }
    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            countries = supabase.postgrest.from("order_detail")
                .select(Columns.list("orderId:order_id", "amount", "menuId:menu_id", "option"))
                .decodeList<OrderDetail>()
        }
    }
    LazyColumn {
        items(
            countries
        ) { country ->
            // Display country.name
//            val inputString = country.time
//            val formatterInput = DateTimeFormatter.ISO_LOCAL_DATE_TIME
//            val dateTime = LocalDateTime.parse(inputString, formatterInput)
//            val formatterOutput = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")
//            val formattedString = dateTime.format(formatterOutput)
            Text(
                country.orderId.toString(),
                modifier = Modifier.padding(8.dp),
            )
            Text(
                country.amount.toString(),
                modifier = Modifier.padding(8.dp),
            )
        }
    }
}