package com.example.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import repositorio.RepositorioPelicula

@Module
@InstallIn(SingletonComponent::class)
abstract class DateModule{
    @Binds
    abstract fun bindFilmRepository(impl: RepositorioPeliculaImpl): RepositorioPelicula
}
