package com.example.data.repository.product

import com.example.routes.product.CreateProductParams
import com.example.utils.BaseResponse

interface ProductRepository {
    suspend fun uploadProduct(params: CreateProductParams): BaseResponse<Any>
}