package com.example

import com.example.config.configureContentNegotiation
import com.example.config.configureDatabase
import com.example.config.configureRouting
import com.example.security.configureSecurity
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureDatabase()
        configureContentNegotiation()
        //configureStatusPages()
        configureSecurity()
        configureRouting()
    }.start(wait = true)
}
