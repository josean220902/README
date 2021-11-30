package com.example.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import repositorio.RepositorioPelicula

@Module
@InstallIn(ActivityComponent::class)
abstract class DateModule{
    @Binds
    abstract fun bindFilmRepository(impl: RepositorioPeliculaImpl): RepositorioPelicula
}
