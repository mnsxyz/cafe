package com.example.cafe.data

import kotlinx.serialization.Serializable

@Serializable
data class Order(
    val id: Int = 0,
    val sequence: Int,
    val name: String,
    val amount: String,
    val menu: String,
    val status: String
)