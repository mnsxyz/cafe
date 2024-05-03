package com.example.cafe.ui.view.order

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cafe.data.OrderEntity
import com.example.cafe.ui.component.FloatingAddButton
import java.time.format.DateTimeFormatter

var orders by mutableStateOf(listOf<OrderEntity>())

@Composable
fun Home() {
    val showDialog = remember { mutableStateOf(false) }
    val clickedIndex = remember { mutableIntStateOf(-1) }
    Scaffold(
        floatingActionButton = {
            FloatingAddButton(
                showDialog = showDialog,
                clickedIndex = clickedIndex,
                onClick = {
                    showDialog.value = true
                    clickedIndex.intValue = -1
                }
            )
        },
        content = { padding ->
            LazyColumn(
                modifier = Modifier.padding(padding)
            ) {
                item { Header() }
                items(orders) { order ->
                    OrderRow(
                        order = order,
                        clickedIndex = clickedIndex
                    )
                }
            }
            if (showDialog.value)
                OrderDialog(
                    showDialog = showDialog,
                    clickedIndex = clickedIndex,
                    orders = orders
                )
        }
    )
}

@Composable
fun OrderDialog(
    showDialog: MutableState<Boolean>,
    clickedIndex: MutableState<Int>,
    orders: List<OrderEntity>
) {
    val order: OrderEntity;
    if (!orders.isEmpty())
        order = orders.get(clickedIndex.value)
//    val menu =
    AlertDialog(
        modifier = Modifier.width(1200.dp),
        onDismissRequest = { /*TODO*/ },
        title = { /*TODO*/ },
        text = {
            Column {
                Text("메뉴1")
                Text("메뉴2")

//                    Text("메뉴: ${order.menu}")
//                    Text("금액: ${order.amount}")
//                    Text("시간: ${order.time}")
//                    Text("상태: ${order.status}")
            }
        },
        confirmButton = {
            Button(
                onClick = { /*TODO*/ },
                content = { Text("확인") }
            )
        },
        dismissButton = {
            Button(
                onClick = { showDialog.value = false },
                content = { Text("닫기") }
            )
        }
    )
}


@Composable
fun Header() {
    Row(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val fontSize = 25.sp
        val width = 70.dp
        Text(
            text = "번호",
            fontSize = fontSize,
            modifier = Modifier.width(width)
        )
        Text(
            text = "이름",
            fontSize = fontSize,
            modifier = Modifier.width(width)
        )
        Text(
            text = "메뉴",
            fontSize = fontSize,
            modifier = Modifier.width(width)
        )
        Text(
            text = "금액",
            fontSize = fontSize,
            modifier = Modifier.width(width)
        )
        Text(
            text = "시간",
            fontSize = fontSize,
            modifier = Modifier.width(width)
        )
        Text(
            text = "상태",
            fontSize = fontSize,
            modifier = Modifier.width(width)
        )
    }
}

@Composable
fun OrderRow(
    order: OrderEntity,
    clickedIndex: MutableState<Int>
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .fillMaxWidth()
            .clickable {
                clickedIndex.value = order.sequence
            },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val fontSize = 25.sp
        val width = 70.dp
        Text(
            text = order.sequence.toString(),
            fontSize = fontSize,
            modifier = Modifier.width(width)
        )
        Text(
            text = order.name,
            fontSize = fontSize,
            modifier = Modifier.width(width)
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
            text = order.time.format(DateTimeFormatter.ofPattern("HH:mm")),
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

//fun addOrder(database: CafeDatabase) {
//    val order = OrderEntity(
//        sequence = orders.size,
//        name = "홍길동",
//        menu = "아메리카노",
//        amount = "3000",
//        time = LocalDateTime.now(),
//        status = "주문완료"
//    )
//    CoroutineScope(Dispatchers.IO).launch {
//        database.orderDao().insert(order)
//    }
//    orders += order
//}