package org.tri.openai.api.dto

data class EditRequest(
    /** Model id. */
    val model: String,
    /** Input as starting point for edit. */
    val input: String? = null,
    /** Instruction telling how to edit the input. */
    val instruction: String,
    /** Number of edits to generate, defaults to 1. */
    val n: Int? = null,
    /** Sampling temperature (randomness), 0 to 2, defaults to 1. */
    val temperature: Double? = null,
    /** Top-p probability mass sampling, 0 to 1, defaults to 1. */
    val top_p: Double? = null
)