package org.tri.openai.api

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.tri.openai.api.dto.ChatMessage
import org.tri.openai.api.dto.ChatRequest
import org.tri.openai.api.dto.CompletionRequest
import org.tri.openai.api.dto.EditRequest
import java.io.File

class OpenAiRestClientTest {

    private val apiKey = File("apikey.txt").readText()
    private val client = OpenAiRestClient("https://api.openai.com/", apiKey)

    @Test
    fun listModels() {
        runBlocking {
            val models = client.listModels()
            println(models)
            println(models.data.map { it.id }.sorted().joinToString("\n"))
        }
    }

    @Test
    fun getModel() {
        runBlocking {
            val model = client.getModel(MODEL_ADA)
            println(model)
        }
    }

    @Test
    fun postCompletion() {
        runBlocking {
            val request = CompletionRequest(
                model = MODEL_CURIE,
                prompt = "Write a tagline for a treehouse."
            )
            val completion = client.completion(request)
            println(completion)
            println(completion.choices[0].text)
        }
    }

    @Test
    fun postChat() {
        runBlocking {
            val request = ChatRequest(
                model = MODEL_CHATGPT,
                messages = listOf(ChatMessage("user", "What is the capital of France?"))
            )
            val chat = client.chat(request)
            println(chat)
            println(chat.choices[0].message.content)
        }
    }

    @Test
    fun postEdit() {
        runBlocking {
            val request = EditRequest(
                model = MODEL_DAVINCI_EDIT,
                input = "I like ice cream",
                instruction = "Translate to German"
            )
            val edit = client.edit(request)
            println(edit)
            println(edit.choices[0].text)
        }
    }

}