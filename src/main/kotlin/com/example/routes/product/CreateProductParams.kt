package com.example.routes.product

import kotlinx.serialization.Serializable

@Serializable
data class CreateProductParams(
    val name: String,
    val amount: Int,
    val price: Double,
    val category: String,
    val images: List<ImageData>?
)