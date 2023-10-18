package com.example.routes.auth

import com.example.data.repository.user.UserRepository
import com.example.routes.product.CreateProductParams
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.authRoutes(repository: UserRepository) {
    routing {
        route("/auth") {
            post("/register") {
                val params = call.receive<CreateUserParams>()
                val result = repository.registerUser(params)
                call.respond(result.statusCode, result)
            }

            post("/login") {
                val params = call.receive<UserLoginParams>()
                val result = repository.loginUser(params)
                call.respond(result.statusCode, result)
            }
        }
    }
}