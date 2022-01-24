package com.example.data

import com.example.domain.Pelicula
import es.spain.data.ServerDataSource
import repositorio.RepositorioPelicula
import javax.inject.Inject

class RepositorioPeliculaImpl @Inject constructor(
    private val serverDataSource: ServerDataSource
    ): RepositorioPelicula{
        override suspend fun getPelicula(id: Int, language: String): Pelicula?{
            return runCatching {
                serverDataSource.getFilm(id, language)
            }.getOrNull()
        }
    }

