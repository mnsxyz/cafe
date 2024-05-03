package com.example.cafe.ui.view.user

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.cafe.data.UserEntity
import com.example.cafe.ui.component.FloatingAddButton
import com.example.cafe.ui.view.order.Header


@Composable
fun User() {
    val showDialog = remember { mutableStateOf(false) }
    val clickedIndex = remember { mutableIntStateOf(-1) }
    val users = listOf<UserEntity>()
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
            }
            if (showDialog.value)
                UserDialog(
                    showDialog = showDialog,
                    clickedIndex = clickedIndex,
                    users = users
                )
        }
    )
}

@Composable
fun UserDialog(
    showDialog: MutableState<Boolean>,
    clickedIndex: MutableState<Int>,
    users: List<UserEntity>
) {
    val user = users.get(clickedIndex.value)
    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        title = { /*TODO*/ },
        text = { /*TODO*/ },
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