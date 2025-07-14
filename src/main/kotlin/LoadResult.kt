package com.example

import com.example.dto.TableDto

sealed class LoadResult {
    data class Success(val table: TableDto) : LoadResult()
    data class Failure(val error: String) : LoadResult()
}