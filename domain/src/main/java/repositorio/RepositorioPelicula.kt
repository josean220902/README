package repositorio

import com.example.domain.Pelicula

interface RepositorioPelicula {
    suspend fun getPelicula(id: Int, language: String): Pelicula?
    suspend fun getFilms(language: String): List<Pelicula>?
}