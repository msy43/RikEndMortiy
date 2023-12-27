package com.msy.rikendmortiy.domain.model.character

import com.msy.rikendmortiy.data.remote.dto.character.all.Location
import com.msy.rikendmortiy.data.remote.dto.character.all.Origin

data class AllCharacter(
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
)
