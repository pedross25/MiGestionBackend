package com.example.service.invoice

import com.example.data.models.Customer
import com.example.data.models.Invoice
import com.example.routes.invoice.CreateInvoiceParams

interface InvoiceService {
    suspend fun createInvoice(params: CreateInvoiceParams): Invoice?

    suspend fun getAll(): List<Invoice>
}