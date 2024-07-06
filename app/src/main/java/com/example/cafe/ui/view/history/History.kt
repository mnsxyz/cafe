package com.example.cafe.ui.view.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cafe.data.Orders
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

var orders by mutableStateOf(listOf<Orders>())

@Composable
fun History() {
    Scaffold(
        content = { padding ->
            LazyColumn(
                modifier = Modifier.padding(padding)
            ) {
                items(orders) { order ->
                    OrderRows(order)
                }
            }
        }
    )
}

@Composable
fun OrderRows(orders: Orders) {
    Row(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val fontSize = 25.sp
        val width = 100.dp
        Text(
            text = orders.amount,
            fontSize = fontSize,
            modifier = Modifier.width(width)
        )
        Text(
            text = orders.status,
            fontSize = fontSize,
            modifier = Modifier.width(width)
        )
    }
}

fun addOrders() {
    CoroutineScope(Dispatchers.IO).launch {
    }
}