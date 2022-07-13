package auth.spi

interface CreateRefreshTokenSpi {
    fun generateRefreshToken(accountId: String): String
}