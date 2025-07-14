package com.example.config

import com.example.controller.TableController
import com.example.routes.tableRoutes
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val tableController by inject<TableController>()
    routing {
        tableRoutes(tableController)
    }
}
