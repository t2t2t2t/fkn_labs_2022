package com.example.marvellapp.data.models

data class HeroState<T>(
    val data: T,
    val isLoading: Boolean,
    val error: String? = null
)
