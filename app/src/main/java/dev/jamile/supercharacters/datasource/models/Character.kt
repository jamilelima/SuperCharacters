package dev.jamile.supercharacters.datasource.models

import com.google.gson.annotations.SerializedName

data class Character(
    val id: String,
    val aliases: String,
    val deck: String,
    val offset: String,
    val image: Map<String, String>,
    val name: String,
    @SerializedName("real_name")
    val realName: String,
)
