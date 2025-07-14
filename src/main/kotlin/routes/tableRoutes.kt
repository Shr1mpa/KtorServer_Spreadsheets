package com.example.routes

import com.example.LoadResult
import com.example.dto.TableDto
import com.example.usecase.LoadTableUseCase
import com.example.usecase.SaveTableUseCase
import io.ktor.http.HttpStatusCode
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import org.koin.ktor.ext.inject

fun Routing.tableRoutes() {
    val saveUseCase by inject<SaveTableUseCase>()
    val loadUseCase by inject<LoadTableUseCase>()

    route("/table") {
        post {
            val table = call.receive<TableDto>()
            val result = saveUseCase(table)
            call.respond(HttpStatusCode.OK, result)
        }

        get {
            when (val result = loadUseCase()) {
                is LoadResult.Success -> call.respond(HttpStatusCode.OK, result.table)
                is LoadResult.Failure -> call.respond(HttpStatusCode.NotFound, "Table not found")
            }
        }
    }
}