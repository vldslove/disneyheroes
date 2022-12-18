package com.example.disneyheroes

import retrofit2.Response
import retrofit2.http.GET

interface DisneyCharactersAPI {
    @GET("characters")
    suspend fun getAllCharacters(): Response<AllCharacters>

}