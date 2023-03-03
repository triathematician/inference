package org.tri.openai.api

import org.tri.openai.api.dto.Model
import org.tri.openai.api.dto.ModelResponseWrapper
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Retrofit interface for defining a models rest api.
 * See https://beta.openai.com/docs/api-reference/models
 */
interface ModelsApi {
    @GET("/v1/models")
    suspend fun listModels(): ModelResponseWrapper

    @GET("/v1/models/{modelId}")
    suspend fun getModel(@Path("modelId") modelId: String): Model
}