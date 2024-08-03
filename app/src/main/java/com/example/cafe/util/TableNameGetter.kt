package com.example.cafe.util

import com.example.cafe.annotation.Table

class TableNameGetter private constructor() {

    companion object {
        inline fun <reified T> get(): String {
            val tableNameAnnotation = T::class.annotations.find { it is Table } as? Table
            return tableNameAnnotation?.name ?: ""
        }
    }
}