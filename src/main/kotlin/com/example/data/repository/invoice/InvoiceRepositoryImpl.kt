package com.example.data.repository.invoice

import com.example.routes.invoice.CreateInvoiceParams
import com.example.service.invoice.InvoiceService
import com.example.utils.BaseResponse

class InvoiceRepositoryImpl(
    private val invoiceService: InvoiceService
): InvoiceRepository {
    override suspend fun createInvoice(params: CreateInvoiceParams): BaseResponse<Any> {
        val invoice = invoiceService.createInvoice(params)
        return if (invoice != null) {
            BaseResponse.SuccessResponse(data = invoice)
        } else {
            BaseResponse.ErrorResponse()
        }
    }

    override suspend fun getAll(): BaseResponse<Any> {
        val invoices = invoiceService.getAll()
        return BaseResponse.SuccessResponse(data = invoices)
    }

}