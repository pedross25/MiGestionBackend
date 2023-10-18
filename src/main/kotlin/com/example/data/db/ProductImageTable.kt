package com.example.data.db

import org.jetbrains.exposed.sql.Table

object ProductImageTable: Table("product_image") {
    val id = integer("id").autoIncrement()
    val productId = integer("product_id").references(ProductTable.id)
    val imageUrl = varchar("image_url", 256)
    override val primaryKey = PrimaryKey(id)
}