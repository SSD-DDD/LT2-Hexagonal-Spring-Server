package user.spi

import annotation.Spi

@Spi
interface CreateAccessTokenSpi {
    fun generateAccessToken(accountId: String): String
}