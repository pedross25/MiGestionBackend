package com.example.data.models


data class Customer (
    val id: Int,
    val businessName: String,
    val streetAddress: String? = null,
    val city: String? = null,
    val state: String? = null,
    val postalcode: String? = null,
    val email: String? = null,
    val phoneNumber: String? = null,
    val cif: String,
    val createdAt: String
)