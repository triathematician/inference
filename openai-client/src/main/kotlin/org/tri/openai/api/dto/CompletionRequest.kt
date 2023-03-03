package org.tri.openai.api.dto

import com.fasterxml.jackson.annotation.JsonInclude

/**
 * Request to complete a prompt.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
data class CompletionRequest(
    /** Model id. */
    val model: String,
    /** Prompt text, string or array, defaults to <|endoftext|>. */
    val prompt: String, // or array
    /** Comes after completion of inserted text. */
    val suffix: String? = null,
    /** Max tokens to generate (default 16). */
    val max_tokens: Int? = null,
    /** Sampling temperature (randomness), 0 to 2, defaults to 1. */
    val temperature: Double? = null,
    /** Top-p probability mass sampling, 0 to 1, defaults to 1. */
    val top_p: Double? = null,
    /** Number of completions to generate, defaults to 1. */
    val n: Int? = null,
    /** Whether to stream partial results, defaults to false. */
    val stream: Boolean? = null,
    /** Whether to also return list of most likely tokens, up to 5, defaults to null */
    val logprobs: Int? = null,
    /** Whether to echo back the prompt, defaults to false */
    val echo: Boolean? = null,
    /** Up to 4 sequences where API will stop generating further tokens, defaults to null. */
    val stop: String? = null, // or array
    /** Penalty for existence of a token, -2 to 2, defaults to 0. */
    val presence_penalty: Double? = null,
    /** Penalty for repeated tokens, -2 to 2, defaults to 0. */
    val frequency_penalty: Double? = null,
    /** Number of server-side options to return, must be greater than n, defaults to 1. */
    val best_of: Int? = null,
    /**
     * Modify likelihood of specified tokens in completion. Values are -100 to 100, defaults to null.
     * See https://platform.openai.com/tokenizer for tokens.
     */
    val logit_bias: Map<String, Double>? = null,
    /** Uid of user, defaults to null. */
    val user: String? = null
)