package com.example.data.db.schemas

import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

object ProductTable : Table("product") {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 256)
    val amount = integer("amount")
    val price = double("price")
    val category = varchar("category", 256)
    val template = bool("template")
    val description = text("description")
    val invoiceId = integer("invoice_id").references(InvoiceTable.id, onDelete = ReferenceOption.CASCADE).nullable()
    val createdAt = datetime("created_at").clientDefault { LocalDateTime.now() }

    override val primaryKey = PrimaryKey(id)
}