package user.spi

import annotation.Spi

@Spi
interface SecurityPasswordSpi {
    fun passwordEncode(password: String): String
    fun passwordMatch(rawPassword: String, encodedPassword: String): Boolean
}