package com.msy.rikendmortiy.domain.use_case.get_single_character

import com.msy.rikendmortiy.data.remote.RMApi
import com.msy.rikendmortiy.data.remote.dto.character.single.toSingleCharacter
import com.msy.rikendmortiy.domain.model.character.SingleCharacter
import com.msy.rikendmortiy.domain.repository.RMRepository
import com.msy.rikendmortiy.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetSingleCharacterUseCase @Inject constructor(private val repository: RMRepository) {

    fun executeSingleCharacter(characterID: Int): Flow<Resource<SingleCharacter>> = flow {
        try {
            emit(Resource.Loading())
            val singleCharacter = repository.getSingleCharacter(characterID)
            emit(Resource.Success(singleCharacter.toSingleCharacter()))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "An unexpected error occured"))
        }
    }
}