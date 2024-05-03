package com.example.cafe.ui.view.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.cafe.data.CafeDatabase
import com.example.cafe.data.MenuEntity
import com.example.cafe.ui.component.DropDownMenu
import com.example.cafe.ui.component.FloatingAddButton
import com.example.cafe.ui.view.order.Header


@Composable
fun Menu() {
    val showDialog = remember { mutableStateOf(false) }
    val clickedIndex = remember { mutableIntStateOf(-1) }
    val menus = listOf<MenuEntity>()
    val database = CafeDatabase.getInstance(LocalContext.current)
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
                MenuDialog(
                    showDialog = showDialog,
                    clickedIndex = clickedIndex,
                    menus = menus
                )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuDialog(
    showDialog: MutableState<Boolean>,
    clickedIndex: MutableState<Int>,
    menus: List<MenuEntity>
) {
    val db = CafeDatabase.getInstance(LocalContext.current)
    val menuCategories = db?.menuCategoryDao()?.getAll()
    val options = mutableListOf<String>()
//    for (menuCategory in menuCategories.toList()) {
//        options.add(menuCategory.name)
//    }
//    val menu = menus.get(clickedIndex.value)
    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        title = {
            Row(
                modifier = Modifier.width(300.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("메뉴 추가")
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = null
                )
            }
        },
        text = {
            var menuName by remember { mutableStateOf("") }
            var menuPrice by remember { mutableStateOf("") }

            Column {
                TextField(
                    value = menuName,
                    onValueChange = { menuName = it },
                    label = { Text("메뉴 이름") }
                )
                TextField(
                    value = menuPrice,
                    onValueChange = { menuPrice = it },
                    label = { Text("가격") }
                )
                DropDownMenu(
                    options = listOf("음료", "디저트"),
                    label = "카테고리"
                )
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