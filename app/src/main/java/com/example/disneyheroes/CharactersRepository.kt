package com.example.disneyheroes

import retrofit2.Response

class CharactersRepository {

    suspend fun getAllCharacters(): Response<AllCharacters> {
        return Network().getCharactersApi().getAllCharacters()
    }

    suspend fun getCharacter(): Response<AllCharacters> {
        return Network().getOneCharacter().getOneCharacter()
    }

}