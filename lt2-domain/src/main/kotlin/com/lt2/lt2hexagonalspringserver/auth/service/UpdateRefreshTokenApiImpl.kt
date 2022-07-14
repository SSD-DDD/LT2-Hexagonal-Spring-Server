package com.lt2.lt2hexagonalspringserver.auth.service

import com.lt2.lt2hexagonalspringserver.annotation.DomainService
import com.lt2.lt2hexagonalspringserver.auth.api.UpdateRefreshTokenApi
import com.lt2.lt2hexagonalspringserver.auth.spi.RefreshTokenUpdateSpi
import com.lt2.lt2hexagonalspringserver.user.api.dto.response.TokenDomainResponse
import com.lt2.lt2hexagonalspringserver.user.spi.UserJwtTokenSpi

@DomainService
class UpdateRefreshTokenApiImpl(
    private val refreshTokenUpdateSpi: RefreshTokenUpdateSpi,
    private val jwtTokenSpi: UserJwtTokenSpi
): UpdateRefreshTokenApi {

    override fun execute(token: String): TokenDomainResponse {
        val refreshToken = refreshTokenUpdateSpi.updateRefreshToken(token)

        val accessToken = jwtTokenSpi.getToken(refreshToken.accountId).accessToken
        val newRefreshToken = jwtTokenSpi.getToken(refreshToken.accountId).refreshToken

        return TokenDomainResponse(accessToken, newRefreshToken)
    }
}