package com.example.marvel_app_android.api.model

import com.example.marvel_app_android.data.Hero
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HeroDto(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "thumbnail")
    val thumbnail: Thumbnail,
) {
    fun toHero(): Hero = Hero(
        id = id,
        name = name,
        description = description,
        path = thumbnail.path.replace("http:", "https:") + "." + thumbnail.extension
    )
}
