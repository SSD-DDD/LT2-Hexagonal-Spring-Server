package com.lt2.lt2hexagonalspringserver.auth.api

import com.lt2.lt2hexagonalspringserver.user.api.dto.response.TokenDomainResponse

interface UpdateRefreshTokenApi {
    fun execute(token: String): TokenDomainResponse
}