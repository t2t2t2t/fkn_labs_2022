package com.example.marvellapp.ui.theme.ui.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.marvel_app_android.data.Hero

@Dao
interface HeroesDao {

    @Query("SELECT * FROM heroes WHERE id = :id")
    suspend fun getHero(id: Int): Hero

    @Query("SELECT * FROM heroes")
    suspend fun getAll(): List<Hero>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHeroes(heroes: List<Hero>)

    @Update
    fun updateHero(hero: Hero)

    @Update
    fun updateHeroes(heroes: List<Hero>)

    @Delete
    fun deleteOne(hero: Hero)

    @Delete
    fun deleteAll(heroes: List<Hero>)
}

