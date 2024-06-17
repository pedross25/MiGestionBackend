package com.example.service.invoice

import com.example.data.db.extensions.toCustomer
import com.example.data.db.extensions.toInvoice
import com.example.data.db.schemas.*
import com.example.data.models.Albaran
import com.example.data.models.Invoice
import com.example.routes.invoice.CreateInvoiceParams
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.statements.InsertStatement
import org.jetbrains.exposed.sql.transactions.transaction

class InvoiceServiceImpl : InvoiceService {


    override suspend fun createInvoice(params: CreateInvoiceParams): Invoice? {
        var statement: InsertStatement<Number>? = null
        transaction {
            statement = InvoiceTable.insert {
                it[id] = params.id
                it[paymentmethod] = params.idPaymentMethod
                it[customer] = params.idCustomer
                it[paid] = params.paid
                it[totalPrice] = params.totalPrice
            }
        }
        return statement?.resultedValues?.get(0)?.toInvoice()
    }
        /*invoiceId = statement?.resultedValues?.get(0)?.get(InvoiceTable.id)?.toInt()

        invoiceId?.let { id ->
            params.idAlbarans.forEach { albaranId ->
                InvoiceAlbaranTable.insert {
                    it[this.invoiceId] = id
                    it[this.albaranId] = albaranId
                }
            }

        }
    }
    return if (invoiceId != null) {
        statement?.resultedValues?.get(0)?.toInvoice(getAlbaransIdsForInvoice(invoiceId!!))
    } else {
        statement?.resultedValues?.get(0)?.toInvoice(emptyList())
    }*/


    override suspend fun getAll(): List<Invoice> {
        return transaction {
            InvoiceTable.selectAll()
                .map { row ->
                    val invoiceId = row[InvoiceTable.id]
                    val createdAt = row[InvoiceTable.date].toString()
                    val customer = row[InvoiceTable.customer]
                    val paymentMethod = row[InvoiceTable.paymentmethod]
                    val albarans = getAlbaransIdsForInvoice(invoiceId)
                    val paid = row[InvoiceTable.paid]
                    val totalPrice = row[InvoiceTable.totalPrice]

                    Invoice(
                        id = invoiceId,
                        createdAt = createdAt,
                        //idAlbarans = albarans,
                        paymentMethod = paymentMethod,
                        customer = customer,
                        paid = paid,
                        totalPrice = totalPrice
                    )
                }
        }
    }

    private fun getAlbaransIdsForInvoice(invoiceId: Int): List<Int> {
        return transaction {
            InvoiceAlbaranTable.select { InvoiceAlbaranTable.invoiceId eq invoiceId }
                .map { it[InvoiceAlbaranTable.albaranId] }
        }
    }
}


