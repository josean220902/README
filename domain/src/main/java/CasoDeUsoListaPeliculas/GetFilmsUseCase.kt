package CasoDeUsoListaPeliculas

import repositorio.RepositorioPelicula
import javax.inject.Inject

class GetFilmsUseCase @Inject constructor(   private val repository: RepositorioPelicula
) {
 suspend fun  execute(language: String)= repository.getFilms(language)

}