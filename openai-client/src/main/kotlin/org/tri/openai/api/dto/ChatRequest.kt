package org.tri.openai.api.dto

import com.fasterxml.jackson.annotation.JsonInclude

/**
 * Request to chat with a model.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
data class ChatRequest(
    /** Model id. */
    val model: String,
    /** Messages to generate completions for. */
    val messages: List<ChatMessage>,
    /** Sampling temperature (randomness), 0 to 2, defaults to 1. */
    val temperature: Double? = null,
    /** Top-p probability mass sampling, 0 to 1, defaults to 1. */
    val top_p: Double? = null,
    /** Number of completions to generate, defaults to 1. */
    val n: Int? = null,
    /** Whether to stream partial results, defaults to false. */
    val stream: Boolean? = null,
    /** Up to 4 sequences where API will stop generating further tokens, defaults to null. */
    val stop: String? = null, // or array
    /** Max tokens to generate (default 16). */
    val max_tokens: Int? = null,
    /** Penalty for existence of a token, -2 to 2, defaults to 0. */
    val presence_penalty: Double? = null,
    /** Penalty for repeated tokens, -2 to 2, defaults to 0. */
    val frequency_penalty: Double? = null,
    /**
     * Modify likelihood of specified tokens in completion. Values are -100 to 100, defaults to null.
     * See https://platform.openai.com/tokenizer for tokens.
     */
    val logit_bias: Map<String, Double>? = null,
    /** Uid of user, defaults to null. */
    val user: String? = null
)