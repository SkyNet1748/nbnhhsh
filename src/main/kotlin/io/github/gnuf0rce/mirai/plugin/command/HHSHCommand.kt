package io.github.gnuf0rce.mirai.plugin.command

import io.github.gnuf0rce.mirai.plugin.*
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

    @Handler
    suspend fun CommandSender.handle(vararg words: String) {
        kotlin.runCatching {
            sendMessage(hhsh(words.asList()).joinToString("\n") { item -> "${item.name} -> ${item.trans}" })
        }.onFailure {
            logger.warning { "查询失败 $it" }
            sendMessage("查询失败 $it")
        }
    }
}