package be.vives.pokechamp.model

import com.squareup.moshi.Json

data class PokeBase (
    @Json(name = "count") val pokeScrUrl: String,
    val next: String,
    val results: List<Results>)
