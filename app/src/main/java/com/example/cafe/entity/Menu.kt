package com.example.cafe.entity

import kotlinx.serialization.Serializable

@Serializable
data class Menu(
    val id: Long,
    val name: String,
    val price: Int
)