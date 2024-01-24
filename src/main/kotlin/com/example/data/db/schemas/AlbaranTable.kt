package com.example.data.db.schemas

import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime

object AlbaranTable : Table("albaran") {
    val id = integer("id").autoIncrement()
    val customer = integer("customer_id").references(CustomerTable.id,onDelete = ReferenceOption.CASCADE)
    val fecha = datetime("fecha")

    override val primaryKey = PrimaryKey(id)
}