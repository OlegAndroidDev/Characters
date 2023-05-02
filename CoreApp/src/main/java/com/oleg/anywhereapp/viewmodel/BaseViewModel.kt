package com.oleg.anywhereapp.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oleg.anywhereapp.model.domain.DomainCharacter
import com.oleg.anywhereapp.usecases.BaseUseCase
import com.oleg.anywhereapp.utils.CharactersType
import com.oleg.anywhereapp.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BaseViewModel @Inject constructor(
    private val characterUseCase: BaseUseCase
) : ViewModel() {

    var prevData: List<DomainCharacter>? = null
    var charactersType: CharactersType? = null
    var characterSelected: MutableStateFlow<DomainCharacter?> = MutableStateFlow(null)
    var characterView: View? = null

    // full list of characters
    private val _characters: MutableStateFlow<UIState<List<DomainCharacter>>> =
        MutableStateFlow(UIState.Loading)
    val characters: StateFlow<UIState<List<DomainCharacter>>> get() = _characters

    private val _search: MutableLiveData<List<DomainCharacter>?> = MutableLiveData(null)
    val search: LiveData<List<DomainCharacter>?> get() = _search

    fun getCharacters(charactersType: CharactersType) {
        charactersType?.let {
            viewModelScope.launch {
                characterUseCase(it).collect {
                    _characters.value = it
                }
            }
        }
    }

    fun searchItem(string: String) {
        if (string.isNotBlank()) {
            prevData?.let {
                _search.value = it.filter { domainCharacter ->
                    domainCharacter.name.contains(
                        string,
                        ignoreCase = true
                    ) || domainCharacter.description.contains(string, ignoreCase = true)
                }
            }
        } else {
            _search.value = prevData
        }
    }

    fun setCurrentItem(character: DomainCharacter) {
        characterSelected.value = character
    }
}