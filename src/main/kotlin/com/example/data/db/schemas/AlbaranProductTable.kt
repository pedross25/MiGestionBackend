package com.example.data.db.schemas

import org.jetbrains.exposed.sql.Table

object AlbaranProductTable : Table("albaran_product") {
    val albaranId = integer("albaran_id").references(AlbaranTable.id)
    val productId = integer("product_id").references(ProductTable.id)

    override val primaryKey = PrimaryKey(albaranId, productId)
}