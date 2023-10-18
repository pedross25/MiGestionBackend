package com.example.routes.product

import kotlinx.serialization.Serializable

@Serializable
data class ImageData(
    val fileName: String,
    val imageBytes: ByteArray
)