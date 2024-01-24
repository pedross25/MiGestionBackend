package com.example.routes.customer

import kotlinx.serialization.Serializable

@Serializable
data class CreateCustomerParams(
    val businessName: String,
    val streetAddress: String?,
    val city: String?,
    val state: String?,
    val postalCode: String?,
    val email: String?,
    val phoneNumber: String?,
    val cif: String,
)