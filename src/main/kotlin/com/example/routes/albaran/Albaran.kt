package com.example.routes.albaran

import com.example.data.repository.albaran.AlbaranRepository
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.albaranRoutes(repository: AlbaranRepository) {
    routing {
        route("/albaran") {

            post("create") {
                val params = call.receive<CreateAlbaranParams>()
                val result = repository.createAlbaran(params)
                call.respond(result.statusCode, result)
            }

            get("getAll") {
                val result = repository.getAll()
                call.respond(result.statusCode, result)
            }
        }
    }
}