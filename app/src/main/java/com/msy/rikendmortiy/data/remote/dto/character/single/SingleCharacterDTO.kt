package com.msy.rikendmortiy.data.remote.dto.character.single

import com.msy.rikendmortiy.domain.model.character.SingleCharacter

data class SingleCharacterDTO(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

fun SingleCharacterDTO.toSingleCharacter(): SingleCharacter {
    return SingleCharacter(
        episode = episode,
        gender = gender,
        id = id,
        image = image,
        location = location,
        name = name,
        origin = origin,
        species = species,
        status = status
    )
}