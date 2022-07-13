package user.service

import annotation.DomainService
import user.api.SignInUserApi
import user.api.dto.request.SignInUserDomainRequest
import user.api.dto.response.TokenDomainResponse
import user.exception.PasswordMismatchException
import user.spi.UserJwtTokenSpi
import user.spi.UserSecuritySpi
import user.spi.UserRepositorySpi

@DomainService
class SignInUserApiImpl(
    private val userRepositorySpi: UserRepositorySpi,
    private val userSecuritySpi: UserSecuritySpi,
    private val userJwtTokenSpi: UserJwtTokenSpi
): SignInUserApi {

    override fun signInUser(request: SignInUserDomainRequest): TokenDomainResponse {
        val user = userRepositorySpi.findByAccountId(request.accountId)

        if (!userSecuritySpi.passwordMatch(request.password, user.password)) throw PasswordMismatchException

        val accessToken = userJwtTokenSpi.generateAccessToken(request.accountId)
        val refreshToken = userJwtTokenSpi.generateRefreshToken(request.accountId)

        return TokenDomainResponse(accessToken, refreshToken)
    }
}