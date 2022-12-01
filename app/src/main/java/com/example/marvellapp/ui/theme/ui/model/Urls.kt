package com.example.marvel_app.ui.theme.ui.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Urls (

  @field:Json(name = "type" ) var type : String? = null,
  @field:Json(name = "url"  ) var url  : String? = null

)