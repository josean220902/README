package com.example.data

import com.example.domain.Pelicula
import es.spain.data.ServerDataSource
import repositorio.RepositorioPelicula
import java.lang.Exception
import javax.inject.Inject

class RepositorioPeliculaImpl @Inject constructor(
    private val serverDataSource: ServerDataSource,
    private val databaseDataSource: DatabaseDatasource
) : RepositorioPelicula {
    override suspend fun getPelicula(id: Int, language: String): Pelicula? {
        return try{
            val filmFromServer = serverDataSource.getFilm(id,language)
            databaseDataSource.updateFilms(listOf(filmFromServer))
            filmFromServer
        }catch (exception: Exception){
            databaseDataSource.getFilm(id)
        }
    }

    override suspend fun getFilms(language: String): List<Pelicula>? {
       return try{
           val filmsFromServer = serverDataSource.getFilms(language)
           databaseDataSource.updateFilms(filmsFromServer)
           filmsFromServer
       }catch (exception: Exception){
           databaseDataSource.getFilms()
       }
    }

}

