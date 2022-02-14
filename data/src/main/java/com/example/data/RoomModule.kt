package com.example.data

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RoomModule {
    @Singleton
    @Provides
    fun provideAppDataBase(@ApplicationContext appContext: Context): AppDatebase{
        return Room
            .databaseBuilder(appContext, AppDatebase:: class.java, "database-joseluis")
            .build()
    }
}