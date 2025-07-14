package com.example.config

import com.example.routes.tableRoutes
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        tableRoutes()
    }
}
