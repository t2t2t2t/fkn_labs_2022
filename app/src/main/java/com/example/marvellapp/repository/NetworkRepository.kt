package com.example.marvellapp.repository

import com.example.marvellapp.network.MarvelApiService
import com.example.marvellapp.network.NetworkResult
import com.example.marvel_app_android.api.model.InformationDto
import javax.inject.Inject

class NetworkRepository @Inject constructor(
    private val marvelApiService: MarvelApiService
) {
    suspend fun getAllHeroes(): NetworkResult<InformationDto> {
        return marvelApiService.getCharacters()
    }

    suspend fun getHero(id: Int): NetworkResult<InformationDto> {
        return marvelApiService.getCharacter(id)
    }
}
