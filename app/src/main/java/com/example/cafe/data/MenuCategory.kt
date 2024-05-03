package com.example.cafe.data

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Index
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Entity(
    tableName = "menu_categories",
    indices = [Index(value = ["name"], unique = true)]
)
data class MenuCategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String
)

@Dao
interface MenuCategoryDAO {
    @Query("SELECT * FROM menu_categories")
    fun getAll(): Flow<List<MenuCategoryEntity>>

    @Insert
    fun insert(menuCategory: MenuCategoryEntity)
}
