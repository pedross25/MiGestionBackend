package com.example.data.db.schemas

import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

object InvoiceTable : Table("invoice") {
    val id = integer("id").autoIncrement()
    val date = datetime("date").clientDefault { LocalDateTime.now() }
    val paymentmethod = integer("payment_method_id").references(PaymentMethodTable.id, onDelete = ReferenceOption.CASCADE)
    val customer = integer("customer_id").references(CustomerTable.id, onDelete = ReferenceOption.CASCADE)

    override val primaryKey = PrimaryKey(id)
}