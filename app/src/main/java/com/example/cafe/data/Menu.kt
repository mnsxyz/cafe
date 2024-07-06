package com.example.cafe.data

import kotlinx.coroutines.flow.Flow

data class MenuEntity(
    val id: Int = 0,
    val name: String,
    val price: Int
)

interface MenuDAO {

    fun getAll(): Flow<List<MenuEntity>>

    fun insert(menu: MenuEntity)
}
