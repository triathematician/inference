package org.tri.openai.api.dto

/**
 * Encodes a chat message.
 * The "role" field is usually "user" or "system" or "assistant".
 * "System" messages are usually first, followed by alternating user and assistant messages.
 * The system message helps set the behavior of the assistant.
 * See https://platform.openai.com/docs/guides/chat/introduction
 */
data class ChatMessage(
    /** Role creating the message. */
    val role: String,
    /** Message content. */
    val content: String
)

