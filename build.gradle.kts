plugins {
    val kotlinVersion = "1.5.21"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion

    id("net.mamoe.mirai-console") version "2.6.7"
}

group = "io.github.gnuf0rce.mirai.plugin"
version = "1.0.0"

repositories {
    clear()
    mavenLocal()
    maven(url = "https://maven.aliyun.com/repository/public")
    mavenCentral()
}
