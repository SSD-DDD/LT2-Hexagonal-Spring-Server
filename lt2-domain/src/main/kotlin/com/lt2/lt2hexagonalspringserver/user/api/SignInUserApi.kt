package com.lt2.lt2hexagonalspringserver.user.api

import com.lt2.lt2hexagonalspringserver.user.api.dto.request.SignInUserDomainRequest
import com.lt2.lt2hexagonalspringserver.user.api.dto.response.TokenDomainResponse

interface SignInUserApi {
    fun execute(request: SignInUserDomainRequest): TokenDomainResponse
}