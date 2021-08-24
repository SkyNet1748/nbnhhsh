package io.github.gnuf0rce.mirai.plugin.command

import io.github.gnuf0rce.mirai.plugin.*
import io.github.gnuf0rce.mirai.plugin.data.AutoTranConfig
import net.mamoe.mirai.console.command.*
import net.mamoe.mirai.console.command.descriptor.*
import net.mamoe.mirai.console.util.*
import net.mamoe.mirai.utils.*

object HHSHCommand : SimpleCommand(
    owner = NBNHHSHPlugin,
    "hhsh",
    description = "好好说话"
) {
    @OptIn(ConsoleExperimentalApi::class, ExperimentalCommandDescriptors::class)
    override val prefixOptional: Boolean = false

    private val regex by lazy { AutoTranConfig.pattern.toRegex() }

    @Handler
    suspend fun CommandSender.handle(vararg texts: String) {
        kotlin.runCatching {
            val words = texts.asList().ifEmpty {
                if (this !is CommandSenderOnMessage<*>) return@ifEmpty emptyList()
                regex.findAll(fromEvent.message.contentToString()).map { result -> result.value }.toList()
            }
            sendMessage(hhsh(words).joinToString("\n") { item -> "${item.name} -> ${item.trans}" })
        }.onFailure {
            logger.warning { "查询失败 $it" }
            sendMessage("查询失败 $it")
        }
    }
}