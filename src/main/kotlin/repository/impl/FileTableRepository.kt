package com.example.repository.impl

import com.example.dto.TableDto
import com.example.repository.TableRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import java.io.File

class FileTableRepository(private val file: File) : TableRepository {
    override suspend fun save(table: TableDto): TableDto = withContext(Dispatchers.IO) {
        val json = Json.encodeToString(table)
        file.writeText(json)
        table
    }

    override suspend fun load(): TableDto? = withContext(Dispatchers.IO) {
        if (!file.exists()) return@withContext null

        val content = file.readText()

        try {
            Json.decodeFromString<TableDto>(content)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}