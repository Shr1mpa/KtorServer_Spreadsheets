package com.example.repository

import com.example.dto.TableDto

interface TableRepository {
    suspend fun save(table : TableDto) : TableDto
    suspend fun load() : TableDto?
}