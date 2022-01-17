package com.example.data

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module(includes = [DateModule::class])
class AppModule {
}