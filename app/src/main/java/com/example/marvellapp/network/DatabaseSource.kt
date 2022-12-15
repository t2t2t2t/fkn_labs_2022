package com.example.marvel_app_android.repository

import com.example.marvellapp.data.models.Hero
import com.example.marvellapp.data.dao.HeroesDao
import javax.inject.Inject

class DatabaseSource @Inject constructor(private val dao: HeroesDao) {
    suspend fun getHeroes(): List<Hero> {
        return dao.getAll()
    }

    suspend fun insertHeroes(list: List<Hero>) {
        dao.insertHeroes(list)
    }

    suspend fun getHeroCached(id: Int): Hero = dao.getHero(id)
}
