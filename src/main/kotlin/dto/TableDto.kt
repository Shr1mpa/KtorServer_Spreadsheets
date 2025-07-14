package com.example.domain.dto

import kotlinx.serialization.Serializable

@Serializable
data class TableDto(val grid: List<List<CellDto>>)
