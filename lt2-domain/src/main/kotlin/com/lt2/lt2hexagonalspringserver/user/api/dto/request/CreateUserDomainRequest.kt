package com.lt2.lt2hexagonalspringserver.user.api.dto.request

data class CreateUserDomainRequest(

    val accountId: String,

    val password: String,

    val name: String
)
