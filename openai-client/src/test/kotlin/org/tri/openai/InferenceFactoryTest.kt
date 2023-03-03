package org.tri.openai

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class InferenceFactoryTest {

    @Test
    fun testChat() {
        runBlocking {
            val chat = InferenceFactory().chatGpt35Turbo()
            val request = "haiku for a space data scientist"
            val response = chat.chat(request)
            println("> $request")
            println(response)
        }
    }
}