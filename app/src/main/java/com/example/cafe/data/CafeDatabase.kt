package com.example.cafe.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(
    entities =
    [
        UserEntity::class,
        OrderEntity::class,
        MenuEntity::class,
        MenuCategoryEntity::class
    ],
    version = 1
)
@TypeConverters(DateConverter::class)
abstract class CafeDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun orderDao(): OrderDao
    abstract fun menuDao(): MenuDAO
    abstract fun menuCategoryDao(): MenuCategoryDAO

    companion object {
        private var instance: CafeDatabase? = null

        @Synchronized
        fun getInstance(context: Context): CafeDatabase? {
            if (instance == null) {
                synchronized(CafeDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CafeDatabase::class.java,
                        "cafe-db"
                    ).build()
                }
            }
            return instance
        }
    }
}