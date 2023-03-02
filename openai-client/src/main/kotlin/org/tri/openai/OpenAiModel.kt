package org.tri.openai

data class ResponseWrapper(
    val `object`: String,
    val data: List<Model>
)

data class Model(
    val id: String,
    val `object`: String,
    val created: Long,
    val owned_by: String,
    val root: String,
    val parent: String?,
    val permission: List<ModelPermission>
)

data class ModelPermission(
    val id: String,
    val `object`: String,
    val created: Long,
    val allow_create_engine: Boolean,
    val allow_sampling: Boolean,
    val allow_logprobs: Boolean,
    val allow_search_indices: Boolean,
    val allow_view: Boolean,
    val allow_fine_tuning: Boolean,
    val organization: String,
    val group: String?,
    val is_blocking: Boolean
)

fun main() {
    val client = OpenAiClient()
    val models = client.listModels()
    println(models.map { it.id }.sorted().joinToString("\n"))
}