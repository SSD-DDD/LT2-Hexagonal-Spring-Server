package user.api

import user.api.dto.request.SignInUserDomainRequest
import user.api.dto.response.TokenDomainResponse

interface SignInUserApi {
    fun execute(request: SignInUserDomainRequest): TokenDomainResponse
}