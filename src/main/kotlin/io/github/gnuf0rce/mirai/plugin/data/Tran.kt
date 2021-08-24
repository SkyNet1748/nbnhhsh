package io.github.gnuf0rce.mirai.plugin.data

import kotlinx.serialization.*

@Serializable
data class Context(
    @SerialName("text")
    val text: String
) {
    constructor(words: List<String>): this(words.joinToString(","))
}

@Serializable
data class TranItem(
    @SerialName("name")
    val name: String,
    @SerialName("trans")
    val trans: List<String>
)