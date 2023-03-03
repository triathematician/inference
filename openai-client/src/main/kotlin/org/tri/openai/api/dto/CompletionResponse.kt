package org.tri.openai.api.dto

data class CompletionResponse(
    val id: String,
    val `object`: String,
    val created: Long,
    val model: String,
    val choices: List<CompletionChoice>,
    val usage: TokenUsage
)

data class CompletionChoice(
    val text: String,
    val index: Int,
    val logprobs: Any? = null,
    val finish_reason: String? = null
)