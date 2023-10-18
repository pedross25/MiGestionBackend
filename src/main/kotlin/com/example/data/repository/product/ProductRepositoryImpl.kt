package com.example.data.repository.product

import com.example.config.MESSAGE_EMAIL_ALREADY_REGISTERED
import com.example.routes.product.CreateProductParams
import com.example.security.JwtConfig
import com.example.service.product.ProductService
import com.example.utils.BaseResponse
import io.ktor.http.ContentDisposition.Companion.File
import java.io.File

class ProductRepositoryImpl(
    private val productService: ProductService
): ProductRepository  {

    override suspend fun uploadProduct(params: CreateProductParams): BaseResponse<Any> {

        val product = productService.createProduct(params)
        return if (product != null) {
            saveImages(params)
            BaseResponse.SuccessResponse(data = product)
        } else {
            BaseResponse.ErrorResponse()
        }

    }

    // todo sacar a otro repositorio de imagenes?
    fun saveImages(params: CreateProductParams) {

        val imageData = params.images

        // Genera un nombre único para la imagen (puedes utilizar algún algoritmo de generación de nombres único)
        val uniqueFileName = "${System.currentTimeMillis()}_${imageData?.get(0)?.fileName}"

        // Guarda los bytes de la imagen en el servidor
        val uploadDirectory = "/ruta/del/directorio/en/el/servidor/"
        val imageFile = File("$uploadDirectory$uniqueFileName")
        if (imageData != null) {
            imageFile.writeBytes(imageData[0].imageBytes)
        }

    }
}