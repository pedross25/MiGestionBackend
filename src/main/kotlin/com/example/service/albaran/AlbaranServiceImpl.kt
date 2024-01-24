package com.example.service.albaran

import com.example.data.db.extensions.toAlbaran
import com.example.data.db.schemas.AlbaranProductTable
import com.example.data.db.schemas.AlbaranTable
import com.example.data.models.Albaran
import com.example.routes.albaran.CreateAlbaranParams
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.statements.InsertStatement
import org.jetbrains.exposed.sql.transactions.transaction

class AlbaranServiceImpl: AlbaranService {

    override suspend fun createAlbaran(params: CreateAlbaranParams): Albaran? {
        var statement: InsertStatement<Number>? = null
        var albaranId: Int? = null
        transaction {
            statement = AlbaranTable.insert {
                it[customer] = params.customer
            }

            albaranId = statement?.resultedValues?.get(0)?.get(AlbaranTable.id)?.toInt()

            albaranId?.let { id ->
                params.products.forEach { productId ->
                    AlbaranProductTable.insert {
                        it[this.albaranId] = id
                        it[this.productId] = productId
                    }
                }
            }
        }

        return if (albaranId != null) {
            statement?.resultedValues?.get(0)?.toAlbaran(getProductsIdsForAlbaran(albaranId!!))
        } else {
            statement?.resultedValues?.get(0)?.toAlbaran(emptyList())
        }
    }

    fun getProductsIdsForAlbaran(albaranId: Int): List<Int> {
        return transaction {
            AlbaranProductTable.select { AlbaranProductTable.albaranId eq albaranId }
                .map { it[AlbaranProductTable.productId] }
        }
    }

    override suspend fun getAll(): List<Albaran> {
        return transaction {
            AlbaranTable.selectAll()
                .map { row ->
                    val albaranId = row[AlbaranTable.id]
                    val customer = row[AlbaranTable.customer]
                    val createdAt = row[AlbaranTable.fecha].toString()
                    val productIds = getProductsIdsForAlbaran(albaranId)

                    Albaran(id = albaranId, customer = customer, createdAt = createdAt, albarans = productIds)
                }
        }
    }

}