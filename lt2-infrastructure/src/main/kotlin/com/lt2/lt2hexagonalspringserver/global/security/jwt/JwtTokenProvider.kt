package com.lt2.lt2hexagonalspringserver.global.security.jwt

import com.lt2.lt2hexagonalspringserver.global.security.jwt.JwtProperties.Companion.ACCESS
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties
) {

    fun generateAccessToken(accountId: String) = generateToken(accountId, jwtProperties.accessExp, ACCESS)

    private fun generateToken(accountId: String, exp: Long, type: String): String =
        Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, jwtProperties.secretKey)
            .setSubject(accountId)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + exp * 1000))
            .claim("type", type)
            .compact()
}