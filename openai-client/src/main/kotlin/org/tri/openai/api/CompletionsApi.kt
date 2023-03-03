package org.tri.openai.api

import org.tri.openai.api.dto.CompletionRequest
import org.tri.openai.api.dto.CompletionResponse
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Retrofit interface for /completions endpoint.
 * See https://beta.openai.com/docs/api-reference/completions
 */
interface CompletionsApi {
    @POST("/v1/completions")
    suspend fun complete(@Body request: CompletionRequest): CompletionResponse
}