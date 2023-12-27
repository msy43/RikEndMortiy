package com.msy.rikendmortiy.data.remote.dto.character.all

import com.msy.rikendmortiy.domain.model.character.AllCharacter

data class AllCharacterDTO(
    val info: Info,
    val results: List<Result>
)

fun AllCharacterDTO.toAllCharacter(): List<AllCharacter> {
    return results.map {
        AllCharacter(
            gender = it.gender,
            id = it.id,
            image = it.image,
            location = it.location,
            name = it.name,
            origin = it.origin,
            species = it.species,
            status = it.status
        )
    }
}