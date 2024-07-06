package com.example.cafe.data

import java.time.LocalDateTime

data class OrderEntity(
    val id: Int = 0,
    val sequence: Int,
    val name: String,
    val amount: String,
    val menu: String,
    val time: LocalDateTime,
    val status: String
)

interface OrderDao {
    fun getAll(): List<OrderEntity>

    fun insert(order: OrderEntity)

    suspend fun deleteAll()
}