package com.example.data

import com.example.domain.Pelicula
import javax.inject.Inject

class DatabaseDatasource @Inject constructor(
    private val database: AppDatebase
) {
    suspend fun getFilms(): List<Pelicula> {
        return database.filmDao().getFilms().map { it.toDomain() }
    }

    suspend fun getFilm(id: Int): Pelicula? {
        return database.filmDao().getFilm(id)?.toDomain()
    }

    suspend fun updateFilms(films:List<Pelicula>){
        database.filmDao().insertAll(films.map{it.toEntity()})
    }

    suspend fun clearFilms() {
        database.filmDao().deleteAll()
    }

    private fun FilmEntity.toDomain(): Pelicula =
        Pelicula(
            title,
            id,
            imageUrl?:"",
            rating,
            director,
            description,
            videoId
        )
    private fun Pelicula.toEntity(): FilmEntity =
        FilmEntity(
            id,
            tittle,
            url,
            director,
            description,
            rating,
            videoId


        )

}
