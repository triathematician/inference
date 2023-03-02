package org.tri.openai

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File

private val apiUrl = "https://api.openai.com/v1/"
private val mediaType = "application/json; charset=utf-8"
private val apiKey = File("apikey.txt").readText()
private val mapper = ObjectMapper().registerModule(KotlinModule())

class OpenAiClient() {
    private val client = OkHttpClient()
    private val objectMapper = ObjectMapper()
        .registerModule(KotlinModule())

    private fun request(endpoint: String) = Request.Builder()
        .url(apiUrl + endpoint)
        .addHeader("Authorization", "Bearer $apiKey")
        .addHeader("Content-Type", mediaType)

    fun listModels(): List<Model> {
        val request = request("models").build()
        val response = client.newCall(request).execute()
        val responseString = response.body?.string()
        println(responseString)
        val result = objectMapper.readValue<ResponseWrapper>(responseString ?: "")
        return result.data
    }

    fun createChat(chatRequest: ChatRequest): ChatCompletion {
        val request = request("chat/completions")
            .post(mapper.writeValueAsString(chatRequest).toRequestBody(mediaType.toMediaType()))
            .build()
        val response = client.newCall(request).execute()
        val responseString = response.body?.string()
        val result = objectMapper.readValue<ChatCompletion>(responseString ?: "")
        return result
    }
}