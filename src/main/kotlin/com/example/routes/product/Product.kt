package com.example.routes.product

import com.example.data.repository.product.ProductRepository
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.productRoutes(repository: ProductRepository) {
    routing {
        route("/product") {
            //authenticate {
                post ("/create") {
                    val params = call.receive<CreateProductParams>()
                    val result = repository.uploadProduct(params)
                    call.respond(result.statusCode, result)
                }

                get("getAll") {
                    val result = repository.getAll()
                    call.respond(result.statusCode, result)
                }
            //}
        }
    }
}