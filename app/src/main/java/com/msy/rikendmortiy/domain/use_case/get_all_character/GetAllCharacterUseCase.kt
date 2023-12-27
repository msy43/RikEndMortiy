package com.msy.rikendmortiy.domain.use_case.get_all_character

import com.msy.rikendmortiy.data.remote.dto.character.all.toAllCharacter
import com.msy.rikendmortiy.domain.model.character.AllCharacter
import com.msy.rikendmortiy.domain.repository.RMRepository
import com.msy.rikendmortiy.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllCharacterUseCase @Inject constructor(private val repository: RMRepository) {

    fun executeGetAllCharacter(page: Int): Flow<Resource<List<AllCharacter>>> = flow {
        try {
            emit(Resource.Loading())
            val allCharacter = repository.getAllCharacter(page)
            emit(Resource.Success(allCharacter.toAllCharacter()))

        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "An unexpected error occured"))
        }
    }
}