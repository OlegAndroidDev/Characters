package com.oleg.anywhereapp.model.domain

import com.oleg.anywhereapp.model.RelatedTopicModel
import com.oleg.anywhereapp.rest.BaseService

data class DomainCharacter (
    val name: String,
    val description: String,
    val image: String? = null
    )

fun List<RelatedTopicModel>?.mapToDomainCharacters(): List<DomainCharacter> {
    return this?.map {
        val items = it.text?.split('-') ?: emptyList()
        DomainCharacter(
            name = if(items.isNotEmpty()) items[0] else "Invalid Name",
            description = it.text ?: "No Description",
            image = it.icon?.uRL?.run {
                "${BaseService.IMAGE_BASE_URL}${this}" } ?: ""
        )
    } ?: emptyList()
}