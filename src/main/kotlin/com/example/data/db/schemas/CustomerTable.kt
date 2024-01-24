package com.example.data.db.schemas

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

object CustomerTable: Table("customer") {
    val id = integer("id").autoIncrement()
    val businessName = varchar("name", 256)
    val streetAddress = varchar("street_address", 256).nullable()
    val city = varchar("city", 100).nullable()
    val state = varchar("state", 100).nullable()
    val postalCode = varchar("postal_code", 20).nullable()
    val email = varchar("email", 256).nullable()
    val phoneNumber = varchar("phone_number", 20).nullable()
    val cif = varchar("cif", 20)
    val createdAt = datetime("created_at").clientDefault { LocalDateTime.now() }
    override val primaryKey = PrimaryKey(id)
}