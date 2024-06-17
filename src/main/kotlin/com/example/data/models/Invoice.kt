package com.example.data.models

data class Invoice(
    val id: Int,
    val createdAt: String,
    val customer: Int,
    val paymentMethod: Int,
    val paid: Boolean,
    val totalPrice: Double
)