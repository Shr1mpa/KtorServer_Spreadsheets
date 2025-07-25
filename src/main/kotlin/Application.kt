package com.example

import com.example.config.configureKoin
import com.example.config.configureMonitoring
import com.example.config.configureRouting
import com.example.config.configureSerialization
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    configureMonitoring()
    configureKoin()
    configureRouting()
}
