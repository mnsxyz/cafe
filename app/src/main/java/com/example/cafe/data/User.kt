package com.example.cafe.data

import kotlinx.coroutines.flow.Flow

data class UserEntity(
    val id: Int = 0,
    val name: String,
    val balance: Int = 0
)


interface UserDao {

    fun getAll(): Flow<List<UserEntity>>

    fun insert(user: UserEntity)
}
