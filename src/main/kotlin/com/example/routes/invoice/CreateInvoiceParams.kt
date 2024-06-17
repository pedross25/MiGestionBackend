package com.example.routes.invoice

import kotlinx.serialization.Serializable

@Serializable
data class CreateInvoiceParams(
    val id: Int,
    val idCustomer: Int,
    val idAlbarans: List<Int>,
    val idPaymentMethod: Int,
    val totalPrice: Double,
    val paid: Boolean
)