package com.lt2.lt2hexagonalspringserver.global.security

import com.lt2.lt2hexagonalspringserver.global.annotation.Adapter
import com.lt2.lt2hexagonalspringserver.global.security.jwt.JwtTokenProvider
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import user.spi.CurrentUserSpi
import user.spi.UserJwtTokenSpi
import user.spi.SecurityPasswordSpi

@Adapter
class SecurityAdapter(
    private val passwordEncoder: PasswordEncoder
): SecurityPasswordSpi, CurrentUserSpi {

    override fun passwordEncode(password: String): String = passwordEncoder.encode(password)

    override fun passwordMatch(rawPassword: String, encodedPassword: String) =
        passwordEncoder.matches(rawPassword, encodedPassword)

    override fun currentUser(): String = SecurityContextHolder.getContext().authentication.name
}