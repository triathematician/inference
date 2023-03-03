package org.tri.openai.api

import org.tri.openai.api.dto.ChatRequest
import org.tri.openai.api.dto.ChatResponse
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Retrofit interface for /chat/completions endpoint.
 * See https://beta.openai.com/docs/api-reference/chat
 */
interface ChatApi {
    @POST("/v1/chat/completions")
    suspend fun chat(@Body request: ChatRequest): ChatResponse
}