package com.example.config

import com.example.data.db.DatabaseFactory
import com.example.di.RepositoryProvider
import com.example.routes.albaran.albaranRoutes
import com.example.routes.auth.authRoutes
import com.example.routes.customer.customersRoutes
import com.example.routes.files.fileRoutes
import com.example.routes.invoice.invoiceRoutes
import com.example.routes.product.productRoutes
import io.ktor.serialization.jackson.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*


fun configureDatabase() {
    DatabaseFactory.init()
}

fun Application.configureContentNegotiation() {
    install(ContentNegotiation) {
        jackson()
    }
}

fun Application.configureRouting(){
    authRoutes(RepositoryProvider.provideUserRepository())
    productRoutes(RepositoryProvider.provideProductRepository())
    customersRoutes(RepositoryProvider.provideCustomerRespository())
    albaranRoutes(RepositoryProvider.provideAlbaranRespository())
    invoiceRoutes(RepositoryProvider.provideInvoiceRespository())
    fileRoutes()


}