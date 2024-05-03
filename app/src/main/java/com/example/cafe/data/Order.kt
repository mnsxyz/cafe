package com.example.cafe.data

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import java.time.LocalDateTime

@Entity(tableName = "orders")
data class OrderEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val sequence: Int,
    val name: String,
    val amount: String,
    val menu: String,
    val time: LocalDateTime,
    val status: String
)

@Dao
interface OrderDao {
    @Query("SELECT * FROM orders")
    fun getAll(): List<OrderEntity>

    @Insert
    fun insert(order: OrderEntity)

    @Query("DELETE FROM orders")
    suspend fun deleteAll()
}