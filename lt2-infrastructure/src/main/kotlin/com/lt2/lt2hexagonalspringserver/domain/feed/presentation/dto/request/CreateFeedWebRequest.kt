package com.lt2.lt2hexagonalspringserver.domain.feed.presentation.dto.request

import javax.validation.constraints.NotBlank

data class CreateFeedWebRequest(

    @field:NotBlank
    val title: String,

    @field:NotBlank
    val content: String
)
