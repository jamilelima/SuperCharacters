package dev.jamile.supercharacters.datasource.models

import com.google.gson.annotations.SerializedName

data class HeroesResponse(
    val error: String,
    val limit: Int,
    val offset: Int,
    @SerializedName("number_of_page_results")
    val pageResults: Int,
    @SerializedName("number_of_total_results")
    val totalResult: Int,
    @SerializedName("status_code")
    val statusCode: Int,
    val results: List<Character>,
)