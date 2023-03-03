package org.tri.openai.api.dto

data class ChatResponse(
    val id: String,
    val `object`: String,
    val model: String,
    val created: Long,
    val choices: List<ChatChoice>,
    val usage: TokenUsage
)

data class ChatChoice(
    val index: Int,
    val message: ChatMessage,
    val finish_reason: String? = null
)