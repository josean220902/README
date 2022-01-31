package CasoDeUsoListaPeliculas

import repositorio.RepositorioPelicula
import javax.inject.Inject

class CasoDeUsoListaPeliculas @Inject constructor(
    private val repository: RepositorioPelicula
) {
    suspend fun execute(id: Int, language: String) = repository.getPelicula(id, language)

}