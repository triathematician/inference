package org.tri.openai.api

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.tri.openai.api.dto.ChatResponse
import org.tri.openai.api.dto.ChatRequest
import org.tri.openai.api.dto.Model
import org.tri.openai.api.dto.ModelResponseWrapper
import java.io.File

object OpenAiRestClientOkHttp {
    private val apiUrl = "https://api.openai.com/v1/"
    private val mediaType = "application/json; charset=utf-8"
    private val apiKey = File("apikey.txt").readText()
    private val mapper = ObjectMapper().registerModule(KotlinModule())

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
        val result = objectMapper.readValue<ModelResponseWrapper>(responseString ?: "")
        return result.data
    }

    fun createChat(chatRequest: ChatRequest): ChatResponse {
        val requestString = mapper.writeValueAsString(chatRequest)
        println(requestString)
        val request = request("chat/completions")
            .post(requestString.toRequestBody(mediaType.toMediaType()))
            .build()
        val response = client.newCall(request).execute()
        val responseString = response.body?.string()
        println(responseString)
        return objectMapper.readValue(responseString ?: "")
    }
}