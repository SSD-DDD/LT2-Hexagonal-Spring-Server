package user.spi

import annotation.Spi

@Spi
interface UserJwtTokenSpi {
    fun generateAccessToken(accountId: String): String
    fun generateRefreshToken(accountId: String): String
}