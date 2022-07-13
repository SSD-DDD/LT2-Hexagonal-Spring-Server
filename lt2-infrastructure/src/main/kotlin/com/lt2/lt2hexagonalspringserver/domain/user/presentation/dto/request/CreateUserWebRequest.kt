package com.lt2.lt2hexagonalspringserver.domain.user.presentation.dto.request

import javax.validation.constraints.NotBlank

data class CreateUserWebRequest(

    @field:NotBlank
    val accountId: String,

    @field:NotBlank
    val password: String,

    @field:NotBlank
    val name: String
)