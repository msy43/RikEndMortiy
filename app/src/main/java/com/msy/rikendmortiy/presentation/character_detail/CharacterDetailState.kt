package com.msy.rikendmortiy.presentation.character_detail

import com.msy.rikendmortiy.domain.model.character.AllCharacter
import com.msy.rikendmortiy.domain.model.character.SingleCharacter

data class CharacterDetailState(
    val isLoading: Boolean = false,
    val character: SingleCharacter? = null,
    val error: String = ""
)