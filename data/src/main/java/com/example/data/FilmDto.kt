package com.example.data

import android.icu.text.CaseMap
import com.google.gson.annotations.SerializedName

data class FilmDto(
    @SerializedName("title") val title: String,
    @SerializedName("id") val id: Int,
    @SerializedName("overview") val description: String,
    @SerializedName("vote_average") val rating: Double,
    @SerializedName("poster_path") val imageUrl: String
)

