package com.example.marvel_app_android.api.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ThumbnailDto(
    @Json(name = "extension")
    val extension: String,
    @Json(name = "path")
    val path: String
)

