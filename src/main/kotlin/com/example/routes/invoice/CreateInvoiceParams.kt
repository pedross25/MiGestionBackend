package com.example.routes.invoice

import kotlinx.serialization.Serializable

@Serializable
data class CreateInvoiceParams(
    val idCustomer: Int,
    val idAlbarans: List<Int>,
    val idPaymentMethod: Int
)