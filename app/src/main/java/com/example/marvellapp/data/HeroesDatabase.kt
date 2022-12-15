package com.example.marvel_app_android.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.marvellapp.data.dao.HeroesDao
import com.example.marvellapp.data.models.Hero

@Database(
    entities = [Hero::class],
    version = 1,
    exportSchema = false
)
abstract class HeroesDatabase : RoomDatabase() {
    abstract fun getHeroesDao(): HeroesDao

}
