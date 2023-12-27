package com.msy.rikendmortiy.domain.repository

import com.msy.rikendmortiy.data.remote.dto.character.all.AllCharacterDTO
import com.msy.rikendmortiy.data.remote.dto.character.single.SingleCharacterDTO

interface RMRepository {

    suspend fun getAllCharacter(page: Int): AllCharacterDTO

    suspend fun getSingleCharacter(characterID: Int): SingleCharacterDTO

}