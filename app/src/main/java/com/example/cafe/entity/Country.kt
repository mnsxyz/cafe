package com.example.cafe.entity

import com.example.cafe.annotation.Table
import kotlinx.serialization.Serializable

@Table(name = "countries")
@Serializable
data class Country(
    val id: Long,
    val name: String,
    val time: String
)
