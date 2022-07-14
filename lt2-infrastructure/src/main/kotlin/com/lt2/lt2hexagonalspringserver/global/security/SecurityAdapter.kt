package com.lt2.lt2hexagonalspringserver.global.security

import com.lt2.lt2hexagonalspringserver.domain.user.domain.UserEntity
import com.lt2.lt2hexagonalspringserver.domain.user.domain.repository.UserRepository
import com.lt2.lt2hexagonalspringserver.global.annotation.Adapter
import com.lt2.lt2hexagonalspringserver.user.User
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import com.lt2.lt2hexagonalspringserver.user.spi.CurrentUserSpi
import com.lt2.lt2hexagonalspringserver.user.spi.SecurityPasswordSpi
import java.util.*

@Adapter
class SecurityAdapter(
    private val passwordEncoder: PasswordEncoder
): SecurityPasswordSpi {

    override fun passwordEncode(password: String): String = passwordEncoder.encode(password)

    override fun passwordMatch(rawPassword: String, encodedPassword: String) =
        passwordEncoder.matches(rawPassword, encodedPassword)
}