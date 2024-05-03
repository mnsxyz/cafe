package com.example.cafe.ui.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FloatingAddButton(
    showDialog: MutableState<Boolean>,
    clickedIndex: MutableIntState,
    onClick: () -> Unit
) {
    ExtendedFloatingActionButton(
        modifier = Modifier
            .padding(horizontal = 30.dp, vertical = 20.dp)
            .height(60.dp)
            .width(120.dp),
        onClick = onClick,
    ) {
        Icon(Icons.Filled.Add, "")
        Spacer(modifier = Modifier.size(10.dp))
        Text(fontSize = 14.sp, text = "추가")
    }
}
