package com.msy.rikendmortiy.data.remote.dto.character.all

import com.msy.rikendmortiy.data.remote.dto.character.all.Result
import com.msy.rikendmortiy.domain.model.character.AllCharacter

data class Result(
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