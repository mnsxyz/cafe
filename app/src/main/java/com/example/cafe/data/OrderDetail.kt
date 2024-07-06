package com.example.cafe.data

import kotlinx.serialization.Serializable

@Serializable
data class OrderDetail(
    val orderId: Int,
    val menuId: Int,
    val amount: Int,
    val option: Int
)