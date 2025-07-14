package com.example.controller

import com.example.LoadResult
import com.example.dto.TableDto
import com.example.usecase.LoadTableUseCase
import com.example.usecase.SaveTableUseCase
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.request.receive
import io.ktor.server.response.respond

class TableController(
    private val saveTableUseCase: SaveTableUseCase,
    private val loadTableUseCase: LoadTableUseCase
) {
    suspend fun save(call: ApplicationCall) {
        val table = call.receive<TableDto>()
        val result = saveTableUseCase(table)
        call.respond(HttpStatusCode.OK, result)
    }

    suspend fun load(call: ApplicationCall) {
        when (val result = loadTableUseCase()) {
            is LoadResult.Success -> call.respond(HttpStatusCode.OK, result.table)
            is LoadResult.Failure -> call.respond(HttpStatusCode.NotFound, result.error)
        }
    }
}