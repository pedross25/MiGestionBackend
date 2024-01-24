package com.example.data.db.schemas

import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

object InvoiceAlbaranTable : Table("invoice_albaran") {
    val invoiceId = integer("factura_id").references(InvoiceTable.id, onDelete = ReferenceOption.CASCADE)
    val albaranId = integer("albaran_id").references(AlbaranTable.id, onDelete = ReferenceOption.CASCADE)

    override val primaryKey = PrimaryKey(invoiceId, albaranId)
}
