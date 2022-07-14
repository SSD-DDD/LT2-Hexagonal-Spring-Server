package auth.api

import user.api.dto.response.TokenDomainResponse

interface UpdateRefreshTokenApi {
    fun execute(token: String): TokenDomainResponse
}