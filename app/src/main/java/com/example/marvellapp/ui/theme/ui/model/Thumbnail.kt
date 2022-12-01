package com.example.marvel_app.ui.theme.ui.model

import com.squareup.moshi.Json


data class Thumbnail (

  @field:Json(name = "path"      ) var path      : String? = null,
  @field:Json(name = "extension" ) var extension : String? = null

)