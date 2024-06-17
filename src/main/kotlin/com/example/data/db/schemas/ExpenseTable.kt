package com.example.data.db.schemas

import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

object ExpenseTable : Table("expense") {
    val id = integer("id").autoIncrement()
    val date = datetime("date").clientDefault { LocalDateTime.now() }
    val concept = varchar("concept", length = 255)
    val amount = double("amount")
    val type = varchar("type", length = 50)
    val invoiceId = integer("invoice_id").references(InvoiceTable.id, onDelete = ReferenceOption.CASCADE).nullable()
    val notes = text("notes").nullable()

    override val primaryKey = PrimaryKey(id)
}