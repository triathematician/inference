package org.tri.openai.api

import org.tri.openai.api.dto.EditRequest
import org.tri.openai.api.dto.EditResponse
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Retrofit interface for /edits endpoint.
 * See [https://beta.openai.com/docs/api-reference/edits].
 */
interface EditsApi {
    @POST("/v1/edits")
    suspend fun edit(@Body request: EditRequest): EditResponse
}