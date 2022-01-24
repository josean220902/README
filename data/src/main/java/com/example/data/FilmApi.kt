package com.example.data

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val API_KEY = "5ea56ed84f1f4dd1deba6e2a8e0da3fa"
interface FilmApi {

      @GET ("movies/{id}")
      suspend fun getFilm(@Path("id")filmId:Int,
      @Query("api_key")apiKey: String = API_KEY): FilmDto


      @GET ("movies{id}/credits?api_key=$API_KEY")
              suspend fun getCredits(@Path("id")filmId: Int,
                                     @Query("api_key") apiKey:String = API_KEY):CreditsDto
    }


    data class CreditsDto(
        @SerializedName("cast") val cast: List<CastDto>
    )
    data class CastDto(
        @SerializedName("known_for_departament") val role: String,
        @SerializedName("name") val name:String

    )

