package com.example.routes.customer

import com.example.data.repository.customer.CustomerRepository
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.customersRoutes(repository: CustomerRepository) {
    routing {
        route("/customer") {
            get("/getAll") {
                val result = repository.getAllCustomers()
                call.respond(result.statusCode, result)
            }

            post("/create") {
                val params = call.receive<CreateCustomerParams>()
                val result = repository.createCustomer(params)
                call.respond(result.statusCode, result)
            }
        }
    }
}