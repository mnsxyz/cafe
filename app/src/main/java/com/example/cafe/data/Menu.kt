package com.example.cafe.data

import kotlinx.serialization.Serializable

@Serializable
data class Menu(
    val id: Int = 0,
    val name: String,
    val price: Int
)