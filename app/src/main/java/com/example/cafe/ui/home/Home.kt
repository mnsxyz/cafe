package com.example.cafe.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

val header = Order(
    id = "순번",
    name = "이름",
    accountNumber = "계좌번호",
    amount = "금액",
    menu = "메뉴",
    time = "시간",
    status = "상태"
)
var orders by mutableStateOf(listOf(header))


@Composable
fun Home(navController: NavHostController) {
    Scaffold(
        floatingActionButton = { FloatingAddButton() },
        content = { padding ->
            LazyColumn(
                modifier = Modifier.padding(padding)
            ) {
                items(orders) { order ->
                    OrderRow(order)
                }
            }
        }
    )
}

@Composable
fun FloatingAddButton() {
    ExtendedFloatingActionButton(
        modifier = Modifier
            .padding(horizontal = 30.dp, vertical = 20.dp)
            .height(60.dp)
            .width(120.dp),
        onClick = { addOrder() },
    ) {
        Icon(Icons.Filled.Add, "")
        Spacer(modifier = Modifier.size(10.dp))
        Text(fontSize = 14.sp, text = "주문")
    }
}

@Composable
fun OrderRow(order: Order) {
    Row(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val fontSize = 25.sp
        Text(
            text = order.id,
            fontSize = fontSize,
            modifier = Modifier.width(50.dp)
        )
        Text(
            text = order.name,
            fontSize = fontSize,
            modifier = Modifier.width(50.dp)
        )
        Text(
            text = order.amount,
            fontSize = fontSize,
            modifier = Modifier.width(50.dp)
        )
        Text(
            text = order.menu,
            fontSize = fontSize,
            modifier = Modifier.width(50.dp)
        )
        Text(
            text = order.time,
            fontSize = fontSize,
            modifier = Modifier.width(50.dp)
        )
        Text(
            text = order.status,
            fontSize = fontSize,
            modifier = Modifier.width(50.dp)
        )
    }
}

fun addOrder() {
    orders += Order(
        id = orders.size.toString(),
        name = "홍길동",
        menu = "아메리카노",
        amount = "3000",
        time = "21/09 12:00",
        accountNumber = "1234567890",
        status = "주문완료"
    )
}