package com.example.data

import com.example.domain.Pelicula
import repositorio.RepositorioPelicula
import javax.inject.Inject

class RepositorioPeliculaImpl @Inject constructor() : RepositorioPelicula {
    override fun getPelicula(): Pelicula  {
        return Pelicula(tittle = "Fast to Furious 7", url = "", rating = 1.0,director = "")
    }
}