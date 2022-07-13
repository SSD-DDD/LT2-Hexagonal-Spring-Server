package user.spi

import annotation.Spi

@Spi
interface UserSecuritySpi {
    fun passwordEncode(password: String): String
    fun passwordMatch(rawPassword: String, encodedPassword: String): Boolean
}