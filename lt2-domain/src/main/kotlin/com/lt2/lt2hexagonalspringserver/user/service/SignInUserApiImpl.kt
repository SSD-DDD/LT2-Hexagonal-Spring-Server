package user.service

import annotation.DomainService
import user.api.SignInUserApi
import user.api.dto.request.SignInUserDomainRequest
import user.api.dto.response.TokenDomainResponse
import user.exception.PasswordMismatchException
import user.spi.UserJwtTokenSpi
import user.spi.SecurityPasswordSpi
import user.spi.QueryUserSpi

@DomainService
class SignInUserApiImpl(
    private val queryUserSpi: QueryUserSpi,
    private val securityPasswordSpi: SecurityPasswordSpi,
    private val userJwtTokenSpi: UserJwtTokenSpi
): SignInUserApi {

    override fun execute(request: SignInUserDomainRequest): TokenDomainResponse {
        val user = queryUserSpi.findByAccountId(request.accountId)

        if (!securityPasswordSpi.passwordMatch(request.password, user.password)) throw PasswordMismatchException

        val accessToken = userJwtTokenSpi.getToken(request.accountId).accessToken
        val refreshToken = userJwtTokenSpi.getToken(request.accountId).refreshToken

        return TokenDomainResponse(accessToken, refreshToken)
    }
}