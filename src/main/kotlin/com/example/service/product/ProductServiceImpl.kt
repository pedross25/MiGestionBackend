package com.example.service.product

import com.example.data.db.DatabaseFactory
import com.example.data.db.extensions.toProduct
import com.example.data.db.schemas.ProductTable
import com.example.data.models.Customer
import com.example.data.models.Product
import com.example.routes.product.CreateProductParams
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.statements.InsertStatement
import org.jetbrains.exposed.sql.transactions.transaction

class ProductServiceImpl : ProductService {

    override suspend fun createProduct(params: CreateProductParams): Product? {
        var statement1: InsertStatement<Number>? = null
        DatabaseFactory.dbQuery {
            statement1 = ProductTable.insert {
                it[name] = params.name
                it[price] = params.price
                it[category] = params.category
                it[amount] = params.amount
                it[description] = params.description
                it[template] = params.template?: false
                it[invoiceId] = params.invoice
                it[parentId] = params.parentId
            }
        }

        return statement1?.resultedValues?.get(0).toProduct()
    }

    override suspend fun getAll(): List<Product?> {
        return transaction {
            val products = ProductTable.selectAll().map { it.toProduct() }
            if (products.isEmpty()) {
                emptyList<Customer>()
            }
            products
        }
    }

}