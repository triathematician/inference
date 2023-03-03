package org.tri.openai.api

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import org.tri.openai.api.dto.*
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class OpenAiRestClient(baseUrl: String, apiKey: String) {

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.NONE // BODY
        })
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer $apiKey")
                .build()
            chain.proceed(request)
        }.build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(JacksonConverterFactory.create(ObjectMapper().registerModule(KotlinModule())))
        .client(httpClient)
        .build()

    private val modelApi = retrofit.create(ModelsApi::class.java)
    private val completionsApi = retrofit.create(CompletionsApi::class.java)
    private val chatApi = retrofit.create(ChatApi::class.java)
    private val editsApi = retrofit.create(EditsApi::class.java)

    suspend fun listModels() = modelApi.listModels()
    suspend fun getModel(modelId: String) = modelApi.getModel(modelId)

    suspend fun completion(request: CompletionRequest) = completionsApi.complete(request)

    suspend fun chat(request: ChatRequest) = chatApi.chat(request)

    suspend fun edit(request: EditRequest) = editsApi.edit(request)

}