package com.example.data.models

data class Expense (
    val id: Int,
    val createdAt: String,
    val concept: String,
    val amount: Double,
    val type: String,
    val invoice: Int?,
    val notes: String?
)