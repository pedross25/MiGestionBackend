package com.example.data.db.schemas

import com.example.data.db.schemas.ProductTable.autoIncrement
import org.jetbrains.exposed.sql.Table

object PaymentMethodTable : Table("payment_method") {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 256)

    override val primaryKey = PrimaryKey(id)
}