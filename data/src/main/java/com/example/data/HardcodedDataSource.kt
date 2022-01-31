package com.example.data

import com.example.domain.Pelicula
import javax.inject.Inject

class HardcodedDataSource @Inject constructor(
    private val dataSource: HardcodedDataSource
) {
    fun getPelicula(): Pelicula {
        return dataSource.getPelicula()
    }
}