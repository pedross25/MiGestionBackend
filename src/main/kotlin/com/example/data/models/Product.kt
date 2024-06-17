package com.example.data.models

data class Product(
    val id: Int,
    val name: String,
    val amount: Int,
    val price: Double,
    val category: String,
    val createdAt: String,
    val template: Boolean,
    val description: String,
    val invoice: Int?,
    val parentId: Int?,
    var images: List<String>? = null
)