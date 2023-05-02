package com.oleg.anywhereapp.rest

import com.oleg.anywhereapp.model.CharacterResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BaseService {

    @GET("/")
    suspend fun getCharacters(
        @Query("q") q: String,
        @Query("format") format: String = FORMAT
    ): Response<CharacterResponseModel>

    companion object {
        const val BASE_URL = "http://api.duckduckgo.com/"
        const val IMAGE_BASE_URL = "https://duckduckgo.com"
        private const val FORMAT = "json"

        // "https://duckduckgo.com/"
        // http://api.duckduckgo.com/?q=simpsons+characters&format=json
    }
}