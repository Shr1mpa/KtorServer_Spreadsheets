package com.example.dto

import kotlinx.serialization.Serializable

@Serializable
data class TableDto(val grid: List<List<CellDto>>)
