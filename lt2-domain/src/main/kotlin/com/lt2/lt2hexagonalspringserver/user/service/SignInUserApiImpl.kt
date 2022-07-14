package com.lt2.lt2hexagonalspringserver.user.service

import com.lt2.lt2hexagonalspringserver.annotation.DomainService
import com.lt2.lt2hexagonalspringserver.user.api.SignInUserApi
import com.lt2.lt2hexagonalspringserver.user.api.dto.request.SignInUserDomainRequest
import com.lt2.lt2hexagonalspringserver.user.api.dto.response.TokenDomainResponse
import com.lt2.lt2hexagonalspringserver.user.exception.PasswordMismatchException
import com.lt2.lt2hexagonalspringserver.user.spi.UserJwtTokenSpi
import com.lt2.lt2hexagonalspringserver.user.spi.SecurityPasswordSpi
import com.lt2.lt2hexagonalspringserver.user.spi.QueryUserSpi

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