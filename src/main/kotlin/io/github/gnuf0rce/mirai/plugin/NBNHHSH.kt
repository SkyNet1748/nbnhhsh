package io.github.gnuf0rce.mirai.plugin

import io.github.gnuf0rce.mirai.plugin.data.*
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.request.*
import io.ktor.http.*
import net.mamoe.mirai.utils.*

internal val logger by lazy {
    val open = System.getProperty("io.github.gnuf0rce.mirai.plugin.logger", "${true}").toBoolean()
    if (open) NBNHHSHPlugin.logger else SilentLogger
}

suspend fun hhsh(words: List<String>): List<TranItem> = HttpClient(OkHttp).use { client ->
    client.post("https://lab.magiconch.com/api/nbnhhsh/guess") {
        body = Context(words)
        contentType(ContentType.Application.Json)
    }
}