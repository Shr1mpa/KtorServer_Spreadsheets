package com.example.di

import com.example.controller.TableController
import com.example.repository.TableRepository
import com.example.repository.impl.FileTableRepository
import com.example.usecase.LoadTableUseCase
import com.example.usecase.SaveTableUseCase
import org.koin.dsl.module
import java.io.File

val appModule = module {
    single { File("table.json") }

    single<TableRepository> { FileTableRepository(get()) }

    single { SaveTableUseCase(get()) }
    single { LoadTableUseCase(get()) }

    single { TableController(get(), get()) }
}