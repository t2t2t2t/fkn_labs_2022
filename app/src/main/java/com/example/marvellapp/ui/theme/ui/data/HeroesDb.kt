package com.example.marvel_app_android.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.marvellapp.ui.theme.ui.data.HeroesDao

@Database(
    entities = [Hero::class],
    version = 1,
    exportSchema = false
)
abstract class HeroesDb : RoomDatabase() {
    abstract fun getHeroesDao(): HeroesDao

}
