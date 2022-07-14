package auth.spi

import annotation.Spi
import auth.RefreshToken

@Spi
interface RefreshTokenSaveSpi {
    fun saveRefreshToken(refreshToken: RefreshToken)
}