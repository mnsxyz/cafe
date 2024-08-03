package com.example.cafe.entity

import kotlinx.serialization.Serializable

@Serializable
data class Orders(
    val id: Long,
    val amount: String,
    val time: String,
    val status: String
)