package io.github.gnuf0rce.mirai.plugin.data

import net.mamoe.mirai.console.data.ReadOnlyPluginConfig
import net.mamoe.mirai.console.data.ValueDescription
import net.mamoe.mirai.console.data.ValueName
import net.mamoe.mirai.console.data.value

object AutoTranConfig : ReadOnlyPluginConfig("AutoTranConfig") {
    @ValueName("pattern")
    @ValueDescription("自动匹配的正则表达式")
    val pattern: String by value("""[a-z]{4,8}""".toRegex().pattern)

    @ValueName("exclude")
    @ValueDescription("自动匹配的正则表达式")
    val exclude: Set<String> by value(setOf("gkd"))
}