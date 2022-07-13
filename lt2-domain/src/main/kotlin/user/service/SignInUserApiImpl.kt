package user.service

import annotation.DomainService
import user.api.SignInUserApi
import user.api.dto.request.SignInUserDomainRequest
import user.api.dto.response.TokenDomainResponse
import user.exception.PasswordMismatchException
import user.spi.JwtTokenSpi
import user.spi.UserPasswordSpi
import user.spi.UserRepositorySpi

@DomainService
class SignInUserApiImpl(
    private val userRepositorySpi: UserRepositorySpi,
    private val userPasswordSpi: UserPasswordSpi,
    private val jwtTokenSpi: JwtTokenSpi
): SignInUserApi {

    override fun signInUser(request: SignInUserDomainRequest): TokenDomainResponse {
        val user = userRepositorySpi.findByAccountId(request.accountId)

        if (!userPasswordSpi.passwordMatch(user.password, request.password)) throw PasswordMismatchException

        val accessToken = jwtTokenSpi.generateAccessToken(request.accountId)
        
        return TokenDomainResponse(accessToken)
    }
}