package org.tri.openai.api.dto

data class EditResponse(
    val `object`: String,
    val created: Long,
    val choices: List<EditChoice>,
    val usage: TokenUsage
)

data class EditChoice(
    val text: String,
    val index: Int,
    val logprobs: Any? = null,
    val finish_reason: String? = null
)