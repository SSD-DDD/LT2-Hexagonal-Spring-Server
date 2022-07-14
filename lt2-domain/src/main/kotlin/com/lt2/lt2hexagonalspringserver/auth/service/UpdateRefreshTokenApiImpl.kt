package auth.service

import annotation.DomainService
import auth.api.UpdateRefreshTokenApi
import auth.spi.RefreshTokenUpdateSpi
import user.api.dto.response.TokenDomainResponse
import user.spi.UserJwtTokenSpi

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