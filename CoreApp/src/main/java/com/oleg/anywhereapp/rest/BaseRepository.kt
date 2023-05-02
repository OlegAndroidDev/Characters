package com.oleg.anywhereapp.rest

import com.oleg.anywhereapp.model.domain.DomainCharacter
import com.oleg.anywhereapp.model.domain.mapToDomainCharacters
import com.oleg.anywhereapp.utils.CharactersType
import com.oleg.anywhereapp.utils.UIState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

interface BaseRepository {
    fun getCharacters(charactersType: CharactersType): Flow<UIState<List<DomainCharacter>>>
}

class BaseRepositoryImpl @Inject constructor(
    private val service: BaseService,
    private val ioDispatcher: CoroutineDispatcher
) : BaseRepository {

    override fun getCharacters(charactersType: CharactersType): Flow<UIState<List<DomainCharacter>>> =
        flow {
            emit(UIState.Loading)
            try {
                val response = service.getCharacters(charactersType.realType)
                if (response.isSuccessful) {
                    response.body()?.let {
                        emit(UIState.Success(it.relatedTopics.mapToDomainCharacters()))
                    } ?: throw Exception("Response is Null")
                } else {
                    throw Exception(response.errorBody()?.string())
                }
            } catch (e: Exception) {
                emit(UIState.Error(e))
            }
        }.flowOn(ioDispatcher)

}