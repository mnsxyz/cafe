package com.example.cafe.data

import kotlinx.serialization.Serializable

@Serializable
data class MenuCategory(
    val id: Int = 0,
    val name: String
)
