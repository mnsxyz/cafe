package com.example.cafe.entity

import kotlinx.serialization.Serializable

@Serializable
data class OrderDetail(
    val orderId: Long,
    val menuId: Long,
    val amount: Int,
    val option: Int
)