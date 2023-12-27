package com.msy.rikendmortiy.presentation.characters

import com.msy.rikendmortiy.domain.model.character.AllCharacter

data class CharactersState(
    val isLoading: Boolean = false,
    val characters: List<AllCharacter> = emptyList(),
    val error: String = ""
)