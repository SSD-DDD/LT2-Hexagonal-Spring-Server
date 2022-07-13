package com.lt2.lt2hexagonalspringserver.global.security.jwt

import com.lt2.lt2hexagonalspringserver.global.security.auth.AuthDetailsService
import com.lt2.lt2hexagonalspringserver.global.security.jwt.JwtProperties.Companion.PREFIX
import com.lt2.lt2hexagonalspringserver.global.security.jwt.exception.InvalidJwtException
import com.lt2.lt2hexagonalspringserver.global.security.jwt.exception.JwtExpiredException
import com.lt2.lt2hexagonalspringserver.global.security.jwt.exception.JwtValidateException
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.MalformedJwtException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

@Component
class JwtTokenParser(
    private val jwtProperties: JwtProperties,
    private val authDetailsService: AuthDetailsService
) {

    fun parseToken(token: String): String {
        if (token.startsWith(PREFIX)) return token.replace(PREFIX, "")

        throw JwtValidateException
    }

    fun authentication(token: String): Authentication {
        val userDetails = authDetailsService.loadUserByUsername(getTokenBody(token).subject)
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
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