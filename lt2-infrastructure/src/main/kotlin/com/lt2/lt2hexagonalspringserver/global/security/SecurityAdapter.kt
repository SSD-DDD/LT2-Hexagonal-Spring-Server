package com.lt2.lt2hexagonalspringserver.global.security

import com.lt2.lt2hexagonalspringserver.global.annotation.Adapter
import com.lt2.lt2hexagonalspringserver.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import user.spi.UserJwtTokenSpi
import user.spi.UserSecuritySpi

@Adapter
class SecurityAdapter(
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider
): UserSecuritySpi, UserJwtTokenSpi {

    override fun passwordEncode(password: String): String = passwordEncoder.encode(password)

    override fun passwordMatch(rawPassword: String, encodedPassword: String) =
        passwordEncoder.matches(rawPassword, encodedPassword)

    override fun generateAccessToken(accountId: String) = jwtTokenProvider.generateAccessToken(accountId)

    override fun generateRefreshToken(accountId: String) = jwtTokenProvider.generateRefreshToken(accountId)
}