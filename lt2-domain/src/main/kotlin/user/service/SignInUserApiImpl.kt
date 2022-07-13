package user.service

import annotation.DomainService
import auth.spi.CreateRefreshTokenSpi
import user.api.SignInUserApi
import user.api.dto.request.SignInUserDomainRequest
import user.api.dto.response.TokenDomainResponse
import user.exception.PasswordMismatchException
import user.spi.CreateAccessTokenSpi
import user.spi.UserPasswordSpi
import user.spi.UserRepositorySpi

@DomainService
class SignInUserApiImpl(
    private val userRepositorySpi: UserRepositorySpi,
    private val userPasswordSpi: UserPasswordSpi,
    private val createAccessTokenSpi: CreateAccessTokenSpi,
    private val createRefreshTokenSpi: CreateRefreshTokenSpi
): SignInUserApi {

    override fun signInUser(request: SignInUserDomainRequest): TokenDomainResponse {
        val user = userRepositorySpi.findByAccountId(request.accountId)

        if (!userPasswordSpi.passwordMatch(user.password, request.password)) throw PasswordMismatchException

        val accessToken = createAccessTokenSpi.generateAccessToken(request.accountId)
        val refreshToken = createRefreshTokenSpi.generateRefreshToken(request.accountId)

        return TokenDomainResponse(accessToken, refreshToken)
    }
}