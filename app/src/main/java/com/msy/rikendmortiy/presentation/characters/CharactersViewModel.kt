package com.msy.rikendmortiy.presentation.characters

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msy.rikendmortiy.domain.use_case.get_all_character.GetAllCharacterUseCase
import com.msy.rikendmortiy.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getAllCharacterUseCase: GetAllCharacterUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CharactersState())
    val state: State<CharactersState> = _state

    init {
        getAllCharacter(1)
    }


    private fun getAllCharacter(page: Int) {
        getAllCharacterUseCase.executeGetAllCharacter(page).onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = CharactersState(characters = it.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value = CharactersState(error = it.message ?: "Error!")
                }

                is Resource.Loading -> {
                    _state.value = CharactersState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}