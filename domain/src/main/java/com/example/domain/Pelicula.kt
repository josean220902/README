package com.example.domain

data class Pelicula(
    val tittle: String,
    val id: Int,
    val url: String,
    val rating: Double,
    val director: String?,
    val description: String,
    val videoId: String?
)