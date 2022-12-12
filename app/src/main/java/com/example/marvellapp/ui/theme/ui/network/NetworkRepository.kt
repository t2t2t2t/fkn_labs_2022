package com.example.marvel_app_android.repository

import com.example.marvel_app_android.api.MarvelApiService
import com.example.marvel_app_android.api.NetworkResult
import com.example.marvel_app_android.api.model.Information
import javax.inject.Inject

class NetworkRepository @Inject constructor(
    private val marvelApiService: MarvelApiService
) {
    suspend fun getAllHeroes(): NetworkResult<Information> {
        return marvelApiService.getCharacters()
    }

    suspend fun getHero(id: Int): NetworkResult<Information> {
        return marvelApiService.getCharacter(id)
    }
}
