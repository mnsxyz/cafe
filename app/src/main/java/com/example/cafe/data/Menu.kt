package com.example.cafe.data

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Entity(tableName = "menus")
data class MenuEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val price: Int
)

@Dao
interface MenuDAO {

    @Query("SELECT * FROM menus")
    fun getAll(): Flow<List<MenuEntity>>

    @Insert
    fun insert(menu: MenuEntity)
}

//val Americano = Menu(1, "아메리카노", 2000)
//val VanillaLatte = Menu(2, "바닐라라떼", 3000)
//val CafeLatte = Menu(3, "카페라떼", 2500)
//val CafeMocha = Menu(4, "카페모카", 3500)
//val ChocoLatte = Menu(5, "초코라떼", 3000)
//val StrawBerryLatte = Menu(6, "딸기라떼", 3500)
//val GreenGreapeAde = Menu(7, "청포도에이드", 2000)
//val GrapeFruitAde = Menu(8, "자몽에이드", 2000)
