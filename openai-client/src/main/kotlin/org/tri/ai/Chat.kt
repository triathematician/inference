package org.tri.ai

interface Chat {
    suspend fun chat(input: String): String
}