package com.example.routes.invoice

import com.example.data.repository.invoice.InvoiceRepository
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.invoiceRoutes(repository: InvoiceRepository) {
    routing {
        route("/invoice") {
            post("/create") {
                val params = call.receive<CreateInvoiceParams>()
                val result = repository.createInvoice(params)
                call.respond(result.statusCode, result)
            }

            get("/getAll") {
                val result = repository.getAll()
                call.respond(result.statusCode, result)
            }
        }
    }
}