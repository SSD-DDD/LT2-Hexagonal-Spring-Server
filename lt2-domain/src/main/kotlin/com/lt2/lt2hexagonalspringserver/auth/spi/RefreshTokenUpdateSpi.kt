package com.lt2.lt2hexagonalspringserver.auth.spi

import com.lt2.lt2hexagonalspringserver.auth.RefreshToken

interface RefreshTokenUpdateSpi {
    fun updateRefreshToken(token: String): RefreshToken
}
