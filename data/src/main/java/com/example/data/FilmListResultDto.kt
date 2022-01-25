package com.example.data

import com.google.gson.annotations.SerializedName

data class FilmListResultDto (
    @SerializedName("page") val page: Int,
    @SerializedName("results") val films: List<FilmDto>
        )