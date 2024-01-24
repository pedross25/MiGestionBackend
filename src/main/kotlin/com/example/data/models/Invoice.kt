package com.example.data.models

data class Invoice(
    val id: Int,
    val createdAt: String,
    val idAlbarans: List<Int>,
    val customer: Int,
    val paymentMethod: Int
)