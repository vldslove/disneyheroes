package com.example.disneyheroes

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {

    fun getCharactersApi(): DisneyCharactersAPI {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.disneyapi.dev/")
            .build()
        return retrofit.create(DisneyCharactersAPI::class.java)
    }

    fun getOneCharacter(): DisneyCharacterAPI {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.disneyapi.dev/")
            .build()
        return retrofit.create(DisneyCharacterAPI::class.java)
    }

}