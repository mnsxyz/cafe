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
import com.example.cafe.data.CafeDatabase
import com.example.cafe.data.OrderEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.format.DateTimeFormatter

var orders by mutableStateOf(listOf<OrderEntity>())

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
fun OrderRows(order: OrderEntity) {
    Row(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val fontSize = 25.sp
        val width = 100.dp
        Text(
            text = order.sequence.toString(),
            fontSize = fontSize,
            modifier = Modifier
                .width(width)
        )
        Text(
            text = order.name,
            fontSize = fontSize,
            modifier = Modifier
                .width(width)
        )
        Text(
            text = order.menu,
            fontSize = fontSize,
            modifier = Modifier.width(width)
        )
        Text(
            text = order.amount,
            fontSize = fontSize,
            modifier = Modifier.width(width)
        )
        Text(
            text = order.time.format(
                DateTimeFormatter.ofPattern("HH:mm")
            ),
            fontSize = fontSize,
            modifier = Modifier.width(width)
        )
        Text(
            text = order.status,
            fontSize = fontSize,
            modifier = Modifier.width(width)
        )
    }
}

fun addOrders(database: CafeDatabase) {
    CoroutineScope(Dispatchers.IO).launch {
        val ds = database.orderDao().getAll()
        ds.forEach {
            orders += it
        }
//        database.orderDao().deleteAll()
    }
}