package io.github.gnuf0rce.mirai.plugin

import io.github.gnuf0rce.mirai.plugin.command.*
import kotlinx.coroutines.*
import net.mamoe.mirai.console.command.CommandSender.Companion.toCommandSender
import net.mamoe.mirai.console.permission.PermissionService.Companion.testPermission
import net.mamoe.mirai.console.util.*
import net.mamoe.mirai.console.util.CoroutineScopeUtils.childScopeContext
import net.mamoe.mirai.event.*
import net.mamoe.mirai.message.data.MessageSource.Key.quote
import kotlin.coroutines.*

object NBNHHSHListener : CoroutineScope {
    override lateinit var coroutineContext: CoroutineContext

    @OptIn(ConsoleExperimentalApi::class)
    fun start(
        parent: CoroutineScope = GlobalScope,
        regex: Regex = """[a-z]+""".toRegex(),
        exclude: Set<String> = emptySet()
    ) {
        coroutineContext = parent.childScopeContext("NBNHHSHListener")
        globalEventChannel().subscribeMessages {
            regex findingReply {
                if (HHSHCommand.permission.testPermission(toCommandSender()).not()) return@findingReply null
                val words = regex.findAll(message.contentToString()).map { result -> result.value }.toList() - exclude
                if (words.isEmpty()) return@findingReply null
                val tran = hhsh(words).filter { it.trans.isNotEmpty() }
                if (tran.isEmpty()) return@findingReply null

                message.quote() + hhsh(words.toList()).joinToString("\n", "好好说话: ") { item ->
                    "${item.name} -> ${item.trans}"
                }
            }
        }
    }

    fun stop() {
        coroutineContext.cancelChildren()
    }
}