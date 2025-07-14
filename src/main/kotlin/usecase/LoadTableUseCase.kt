package com.example.usecase

import com.example.LoadResult
import com.example.dto.TableDto
import com.example.repository.TableRepository

class LoadTableUseCase(private val repository: TableRepository) {
    suspend operator fun invoke(): LoadResult {
        val table = repository.load()
        return if (table != null) LoadResult.Success(table)
        else LoadResult.Failure("Table not found")
    }
}