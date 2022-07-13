package user.spi

import annotation.Spi

@Spi
interface JwtTokenSpi {
    fun generateAccessToken(accountId: String): String
}