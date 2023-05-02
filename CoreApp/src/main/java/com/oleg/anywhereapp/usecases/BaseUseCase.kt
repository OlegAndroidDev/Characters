package com.oleg.anywhereapp.usecases

import com.oleg.anywhereapp.model.domain.DomainCharacter
import com.oleg.anywhereapp.rest.BaseRepository
import com.oleg.anywhereapp.utils.CharactersType
import com.oleg.anywhereapp.utils.UIState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BaseUseCase @Inject constructor(
    private val repository: BaseRepository
) {
    operator fun invoke(type: CharactersType): Flow<UIState<List<DomainCharacter>>> =
        repository.getCharacters(type)
}