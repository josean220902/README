package com.example.data

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val API_KEY = "5ea56ed84f1f4dd1deba6e2a8e0da3fa"

interface FilmApi {

    @GET("movie/{id}")
    suspend fun getFilm(
        @Path("id") filmId: Int,
        @Query("language") language: String,
        @Query("api_key") apiKey: String = API_KEY
    ): FilmDto


    @GET("movie/{id}/credits")
    suspend fun getCredits(
        @Path("id") filmId: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): CreditsDto

    @GET("movie/popular")
    suspend fun getPopular(
        @Query("language") language: String,
        @Query("api_key") apiKey: String = API_KEY
    ): FilmListResultDto

    @GET("movie/{id}/videos")
    suspend fun getVideos(@Path("id")filmId: Int,
        @Query("language") language: String,
        @Query("api_key") apiKey: String= API_KEY): VideoResultDto



}


data class CreditsDto(
    @SerializedName("cast") val cast: List<CastDto>
)

data class CastDto(
    @SerializedName("known_for_departament") val role: String,
    @SerializedName("name") val name: String

)

