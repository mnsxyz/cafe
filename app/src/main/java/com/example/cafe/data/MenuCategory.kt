package com.example.cafe.data

import kotlinx.coroutines.flow.Flow

data class MenuCategoryEntity(
    val id: Int = 0,
    val name: String
)

interface MenuCategoryDAO {
    fun getAll(): Flow<List<MenuCategoryEntity>>

    fun insert(menuCategory: MenuCategoryEntity)
}
