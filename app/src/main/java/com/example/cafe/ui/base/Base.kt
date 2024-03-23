package com.example.cafe.ui.base

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cafe.ui.navigation.Route
import com.example.cafe.ui.navigation.navigate

@Composable
fun Base(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Text("Base")
        Button(
            onClick = {
                navigate(Route.HOME, navController)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Text("Base")
        }

    }

}