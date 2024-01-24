package com.example.service.product

import com.example.data.models.Product
import com.example.routes.product.CreateProductParams

interface ProductService {
    suspend fun createProduct(params: CreateProductParams): Product?

    suspend fun getAll(): List<Product?>
}