package CasoDeUsos

import com.example.domain.Pelicula
import repositorio.RepositorioPelicula
import javax.inject.Inject

class CasoDeUso @Inject constructor(
    private val repositorioPelicula:RepositorioPelicula
){
  fun execute() = repositorioPelicula.getPelicula()


}


