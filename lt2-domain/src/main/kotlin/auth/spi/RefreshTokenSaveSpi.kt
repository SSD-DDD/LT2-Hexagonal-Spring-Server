package auth.spi

import auth.RefreshToken

interface RefreshTokenSaveSpi {
    fun saveRefreshToken(refreshToken: RefreshToken)
}