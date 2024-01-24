package com.example.routes.albaran

import kotlinx.serialization.Serializable

@Serializable
data class CreateAlbaranParams(
    val customer: Int,
    val products: List<Int>
)