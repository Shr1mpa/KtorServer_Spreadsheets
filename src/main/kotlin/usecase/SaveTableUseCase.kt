package com.example.usecase

import com.example.dto.TableDto
import com.example.repository.TableRepository

class SaveTableUseCase(private val repository: TableRepository) {
    suspend operator fun invoke(table: TableDto): TableDto {
        return repository.save(table)
    }
}