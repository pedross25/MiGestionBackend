package com.example.data.db

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

object ProductTable: Table("product") {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 256)
    val amount = integer("amount")
    val price = double("price")
    val category = varchar("category", 256)
    val createdAt = datetime("created_at").clientDefault { LocalDateTime.now() }
    override val primaryKey = PrimaryKey(id)
}