package com.msy.rikendmortiy.data.remote

import com.msy.rikendmortiy.data.remote.dto.character.all.AllCharacterDTO
import com.msy.rikendmortiy.data.remote.dto.character.single.SingleCharacterDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RMApi {

    @GET("character")
    suspend fun getAllCharacter(
        @Query("page") page: Int
    ) : AllCharacterDTO

    @GET("character/{character_id}")
    suspend fun getSingleCharacter(
        @Path("character_id") character_id: Int
    ) : SingleCharacterDTO
}