package com.example.service.product

import com.example.data.db.DatabaseFactory
import com.example.data.db.ProductImageTable
import com.example.data.db.ProductTable
import com.example.data.db.extensions.toProduct
import com.example.data.models.Product
import com.example.routes.product.CreateProductParams
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.statements.InsertStatement

class ProductServiceImpl: ProductService {

    override suspend fun createProduct(params: CreateProductParams): Product? {
        var statement1: InsertStatement<Number>? = null
        var statement2: InsertStatement<Number>? = null
        DatabaseFactory.dbQuery {
            statement1 = ProductTable.insert {
                it[name] = params.name
                it[amount] = params.amount
                it[price] = params.price
                it[category] = params.category
            }
        }

        val product = statement1?.resultedValues?.get(0).toProduct()
        val imagesList = mutableListOf<String>()

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
        }
    }
}