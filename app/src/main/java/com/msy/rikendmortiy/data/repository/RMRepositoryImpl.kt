package com.msy.rikendmortiy.data.repository

import com.msy.rikendmortiy.data.remote.RMApi
import com.msy.rikendmortiy.data.remote.dto.character.all.AllCharacterDTO
import com.msy.rikendmortiy.data.remote.dto.character.single.SingleCharacterDTO
import com.msy.rikendmortiy.domain.repository.RMRepository
import javax.inject.Inject

class RMRepositoryImpl @Inject constructor(private val api: RMApi) : RMRepository {
    override suspend fun getAllCharacter(page: Int): AllCharacterDTO {
        return api.getAllCharacter(page)
    }

    override suspend fun getSingleCharacter(character_id: Int): SingleCharacterDTO {
        return api.getSingleCharacter(character_id)
    }
}