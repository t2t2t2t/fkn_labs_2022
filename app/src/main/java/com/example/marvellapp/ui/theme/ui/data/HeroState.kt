package com.example.marvel_app_android.data

data class HeroState<T>(
    val data: T,
    val isLoading: Boolean,
    val error: String? = null
)
