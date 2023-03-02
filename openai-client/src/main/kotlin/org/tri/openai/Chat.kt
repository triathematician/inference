package org.tri.openai

data class ChatRequest(
    val model: String,
    val messages: List<ChatMessage>
)

data class ChatMessage(
    val role: String,
    val content: String
)

data class ChatCompletion(
    val id: String,
    val `object`: String,
    val created: Long,
    val choices: List<ChatChoice>,
    val model: String,
    val usage: ChatUsage
)

data class ChatChoice(
    val index: Int,
    val message: ChatMessage,
    val finish_reason: String? = null
)

data class ChatUsage(
    val prompt_tokens: Int,
    val completion_tokens: Int,
    val total_tokens: Int
)

fun main() {
    val client = OpenAiClient()
    val request = "give a motto for a pirate data scientist"
    val res = client.createChat(
        ChatRequest("gpt-3.5-turbo",
        listOf(ChatMessage("user", request)))
    )
    println(request)
    println(res)
    println(res.choices[0].message.content)
}