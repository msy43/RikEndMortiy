package com.msy.rikendmortiy.domain.model.character

import com.msy.rikendmortiy.data.remote.dto.character.single.Location
import com.msy.rikendmortiy.data.remote.dto.character.single.Origin

data class SingleCharacter(
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
)
