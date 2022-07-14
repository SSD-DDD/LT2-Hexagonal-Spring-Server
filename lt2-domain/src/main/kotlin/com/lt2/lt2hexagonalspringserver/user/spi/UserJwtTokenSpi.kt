package com.lt2.lt2hexagonalspringserver.user.spi

import com.lt2.lt2hexagonalspringserver.annotation.Spi
import com.lt2.lt2hexagonalspringserver.user.spi.dto.SpiTokenResponse

@Spi
interface UserJwtTokenSpi {
    fun getToken(accountId: String): SpiTokenResponse
}