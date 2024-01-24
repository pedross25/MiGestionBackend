package com.example.service.product

import com.example.data.db.DatabaseFactory
import com.example.data.db.extensions.toCustomer
import com.example.data.db.schemas.ProductTable
import com.example.data.db.extensions.toProduct
import com.example.data.db.schemas.CustomerTable
import com.example.data.db.schemas.InvoiceTable
import com.example.data.models.Customer
import com.example.data.models.Invoice
import com.example.data.models.Product
import com.example.routes.product.CreateProductParams
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.statements.InsertStatement
import org.jetbrains.exposed.sql.transactions.transaction

class ProductServiceImpl : ProductService {

    override suspend fun createProduct(params: CreateProductParams): Product? {
        var statement1: InsertStatement<Number>? = null
        var statement2: InsertStatement<Number>? = null
        DatabaseFactory.dbQuery {
            statement1 = ProductTable.insert {
                it[name] = params.name
                it[price] = params.price
                it[category] = params.category
                it[amount] = params.amount
                it[description] = params.description
                it[template] = params.template
                it[invoiceId] = params.invoice
            }
        }

        return statement1?.resultedValues?.get(0).toProduct()
        /*       val imagesList = mutableListOf<String>()

        return if (product != null && !params.images.isNullOrEmpty()) {
            val imageInserts = params.images.map { image ->
                val generateUrl = "${product.id} / + ${image.fileName}"
                ProductImageTable.insert {
                    it[productId] = product.id
                    it[imageUrl] = generateUrl
                }
                imagesList.add(generateUrl)
            }
            product.images = imagesList
            product
        } else {
            null
        }*/
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