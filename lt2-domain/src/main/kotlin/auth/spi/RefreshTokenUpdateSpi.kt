package auth.spi

import auth.RefreshToken

interface RefreshTokenUpdateSpi {
    fun updateRefreshToken(token: String): RefreshToken
}
