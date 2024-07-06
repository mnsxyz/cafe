package com.example.cafe.data

import kotlinx.serialization.Serializable

@Serializable
data class Orders(
    val id: Int,
    val amount: String,
    val time: String,
    val status: String
)