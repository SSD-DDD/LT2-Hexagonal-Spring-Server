package com.lt2.lt2hexagonalspringserver.global.security.jwt

import com.lt2.lt2hexagonalspringserver.global.security.jwt.JwtProperties.Companion.PREFIX
import com.lt2.lt2hexagonalspringserver.global.security.jwt.exception.InvalidJwtException
import com.lt2.lt2hexagonalspringserver.global.security.jwt.exception.JwtExpiredException
import com.lt2.lt2hexagonalspringserver.global.security.jwt.exception.JwtValidateException
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.MalformedJwtException
import org.springframework.stereotype.Component

@Component
class JwtTokenParser(
    private val jwtProperties: JwtProperties
) {

    fun parseToken(token: String): String {
        if (token.startsWith(PREFIX)) return token.replace(PREFIX, "")

        throw JwtValidateException
    }

    private fun getTokenBody(token: String): Claims {
        return try {
            Jwts.parser().setSigningKey(jwtProperties.secretKey)
                .parseClaimsJws(token).body
        } catch (e: Exception) {
            when (e) {
                is ExpiredJwtException -> throw JwtExpiredException
                is MalformedJwtException -> throw JwtValidateException
                else -> throw InvalidJwtException
            }
        }
    }
}