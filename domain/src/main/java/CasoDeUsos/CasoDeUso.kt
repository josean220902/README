package CasoDeUsos

import com.example.domain.Pelicula
import repositorio.RepositorioPelicula
import javax.inject.Inject

class CasoDeUso @Inject constructor(
    private val repositorioPelicula:RepositorioPelicula
){
suspend fun execute(id: Int, language:String)= repositorioPelicula.getPelicula(id,language)


}


