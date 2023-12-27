package com.msy.rikendmortiy.presentation.character_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msy.rikendmortiy.domain.use_case.get_single_character.GetSingleCharacterUseCase
import com.msy.rikendmortiy.util.Constants.characterID
import com.msy.rikendmortiy.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getSingleCharacterUseCase: GetSingleCharacterUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CharacterDetailState())
    val state: State<CharacterDetailState> = _state

    init {
        savedStateHandle.get<String>(characterID)?.let {
            getSingleCharacter(it.toInt())
        }
    }

    private fun getSingleCharacter(characterID: Int) {
        getSingleCharacterUseCase.executeSingleCharacter(characterID = characterID).onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = CharacterDetailState(character = it.data)
                }

                is Resource.Error -> {
                    _state.value = CharacterDetailState(error = it.message ?: "Error")
                }

                is Resource.Loading -> {
                    _state.value = CharacterDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}
