package com.example.data.repository.invoice

import com.example.routes.invoice.CreateInvoiceParams
import com.example.utils.BaseResponse

interface InvoiceRepository {

    suspend fun createInvoice(params: CreateInvoiceParams): BaseResponse<Any>

    suspend fun getAll(): BaseResponse<Any>
}