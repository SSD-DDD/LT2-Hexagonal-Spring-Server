package com.lt2.lt2hexagonalspringserver.global.security.jwt

import com.lt2.lt2hexagonalspringserver.auth.RefreshToken
import com.lt2.lt2hexagonalspringserver.auth.spi.RefreshTokenSaveSpi
import com.lt2.lt2hexagonalspringserver.global.security.jwt.JwtProperties.Companion.ACCESS
import com.lt2.lt2hexagonalspringserver.global.security.jwt.JwtProperties.Companion.REFRESH
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import com.lt2.lt2hexagonalspringserver.user.spi.UserJwtTokenSpi
import com.lt2.lt2hexagonalspringserver.user.spi.dto.SpiTokenResponse
import java.util.*

@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties,
    private val refreshTokenSaveSpi: RefreshTokenSaveSpi
): UserJwtTokenSpi {

    override fun getToken(accountId: String) =
        SpiTokenResponse(
            generateAccessToken(accountId),
            generateRefreshToken(accountId)
        )

    private fun generateAccessToken(accountId: String) = generateToken(accountId, jwtProperties.accessExp, ACCESS)

    private fun generateRefreshToken(accountId: String): String {
        val refreshToken = generateToken(accountId, jwtProperties.refreshExp, REFRESH)

        refreshTokenSaveSpi.saveRefreshToken(
            RefreshToken(
                accountId = accountId,
                token = refreshToken,
                ttl = jwtProperties.refreshExp
            )
        )

        return refreshToken
    }

    private fun generateToken(accountId: String, exp: Long, type: String): String =
        Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, jwtProperties.secretKey)
            .setSubject(accountId)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + exp * 1000))
            .claim("type", type)
            .compact()
}