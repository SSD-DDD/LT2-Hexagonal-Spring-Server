package com.lt2.lt2hexagonalspringserver.domain.comment.presentation.dto.request

import javax.validation.constraints.NotBlank

data class CreateCommentWebRequest(

    @field:NotBlank
    val content: String
)
