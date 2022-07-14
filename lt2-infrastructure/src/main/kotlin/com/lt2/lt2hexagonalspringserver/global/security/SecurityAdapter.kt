package com.lt2.lt2hexagonalspringserver.global.security

import com.lt2.lt2hexagonalspringserver.global.annotation.Adapter
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import com.lt2.lt2hexagonalspringserver.user.spi.CurrentUserSpi
import com.lt2.lt2hexagonalspringserver.user.spi.SecurityPasswordSpi
import java.util.*

@Adapter
class SecurityAdapter(
    private val passwordEncoder: PasswordEncoder
): SecurityPasswordSpi, CurrentUserSpi {

    override fun passwordEncode(password: String): String = passwordEncoder.encode(password)

    override fun passwordMatch(rawPassword: String, encodedPassword: String) =
        passwordEncoder.matches(rawPassword, encodedPassword)

    override fun currentUserId(): UUID =
        UUID.fromString(SecurityContextHolder.getContext().authentication.name)
}