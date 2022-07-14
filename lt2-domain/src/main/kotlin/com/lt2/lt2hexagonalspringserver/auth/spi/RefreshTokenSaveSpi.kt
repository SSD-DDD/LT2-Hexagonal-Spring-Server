package com.lt2.lt2hexagonalspringserver.auth.spi

import com.lt2.lt2hexagonalspringserver.annotation.Spi
import com.lt2.lt2hexagonalspringserver.auth.RefreshToken

@Spi
interface RefreshTokenSaveSpi {
    fun saveRefreshToken(refreshToken: RefreshToken)
}