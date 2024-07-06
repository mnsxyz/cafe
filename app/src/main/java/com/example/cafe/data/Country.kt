package com.example.cafe.data

import kotlinx.serialization.Serializable

@Serializable
data class Country(
    val id: Int,
    val name: String,
    val time: String
)
