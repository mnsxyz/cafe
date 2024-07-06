package com.example.cafe.data

import android.content.Context


abstract class CafeDatabase{
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
                    instance
                }
            }
            return instance
        }
    }
}