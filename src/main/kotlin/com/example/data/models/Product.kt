package com.example.data.models

data class Product(
    val id: Int,
    val name: String,
    val amount: Int,
    val price: Double,
    val category: String,
    val createdAt: String,
    var images: List<String>? = null
)