package com.lt2.lt2hexagonalspringserver.global.security.jwt

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")
class JwtProperties(
    val secretKey: String,
    val accessExp: Long,
    val refreshExp: Long
) {
    companion object {
        const val HEADER = "Authorization"
        const val PREFIX = "Bearer"
        const val ACCESS = "access"
        const val REFRESH = "refresh"
    }
}