package es.spain.data

import com.example.data.FilmApi
import com.example.domain.Pelicula
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import javax.inject.Inject

const val BASE_URL = "https://api.themoviedb.org/3/"

class ServerDataSource @Inject constructor() {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api: FilmApi = retrofit.create(FilmApi::class.java)

    suspend fun getFilm(id: Int, language: String): Pelicula {
        val filmDto = api.getFilm(id, language)
        val creditsDto = api.getCredits(id)
        val popularDto = api.getPopular(language)
        val director = creditsDto.cast.firstOrNull { it.role == "Directing" }?.name ?: ""
        val image = "https://image.tmdb.org/t/p/w500${filmDto.imageUrl}"
        return Pelicula(filmDto.title, image, filmDto.rating, director, filmDto.description)

    }

    suspend fun getFilms(language: String): List<Pelicula> {
        return api.getPopular(language).films.map {
            val image = "https://image.tmdb.org/t/p/w500${it.imageUrl}"
            Pelicula(it.title, image, it.rating, null, it.description)
        }
    }

}