package com.example.routes

import com.example.controller.TableController
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route

fun Routing.tableRoutes(controller: TableController) {
    route("/table") {
        post { controller.save(call) }
        get { controller.load(call) }
    }
}