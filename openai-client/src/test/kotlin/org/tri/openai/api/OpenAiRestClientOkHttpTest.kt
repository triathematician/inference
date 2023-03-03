package org.tri.openai.api

fun main() {
    println(
        OpenAiRestClientOkHttp.listModels()
            .map { it.id }.sorted()
            .joinToString("\n")
    )
}