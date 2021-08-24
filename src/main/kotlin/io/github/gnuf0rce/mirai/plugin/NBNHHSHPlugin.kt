package io.github.gnuf0rce.mirai.plugin

import io.github.gnuf0rce.mirai.plugin.command.*
import io.github.gnuf0rce.mirai.plugin.data.*
import net.mamoe.mirai.console.command.CommandManager.INSTANCE.register
import net.mamoe.mirai.console.command.CommandManager.INSTANCE.unregister
import net.mamoe.mirai.console.plugin.jvm.*

object NBNHHSHPlugin : KotlinPlugin(
    JvmPluginDescription(
        id = "io.github.gnuf0rce.mirai.plugin.nbnhhsh",
        name = "nbnhhsh",
        version = "1.0.0",
    ) {
        author("cssxsh")
    }
) {
    override fun onEnable() {
        AutoTranConfig.reload()
        HHSHCommand.register()
        NBNHHSHListener.start(this, AutoTranConfig.pattern.toRegex(), AutoTranConfig.exclude)
    }

    override fun onDisable() {
        HHSHCommand.unregister()
        NBNHHSHListener.stop()
    }
}