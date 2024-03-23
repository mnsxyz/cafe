package com.example.cafe.ui.home

data class Order(
    val id: String,
    val name: String,
    val accountNumber: String,
    val amount: String,
    val menu: String,
    val time: String,
    val status: String
)