package org.tri.openai

import org.tri.ai.Chat
import org.tri.openai.api.dto.ChatMessage
import org.tri.openai.api.dto.ChatRequest
import org.tri.openai.api.OpenAiRestClient
import org.tri.openai.api.MODEL_CHATGPT
import java.io.File

class InferenceFactory {

    private val apiKey = File("apikey.txt").readText()
    private val client = OpenAiRestClient("https://api.openai.com/", apiKey)

    fun chatGpt35Turbo() = object : Chat {
        override suspend fun chat(input: String): String {
            val res = client.chat(
                ChatRequest(MODEL_CHATGPT, listOf(
                    ChatMessage("user", input)
                ))
            )
            return res.choices[0].message.content.trim()
        }
    }

}