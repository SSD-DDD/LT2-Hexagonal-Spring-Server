package user.spi

import annotation.Spi

@Spi
interface GenerateJwtTokenSpi {
    fun generateAccessToken(accountId: String): String
    fun generateRefreshToken(accountId: String): String
}