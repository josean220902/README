package com.example.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FilmEntity::class], version = 1)
abstract class AppDatebase : RoomDatabase() {
    abstract fun filmDao(): FilmDao
}