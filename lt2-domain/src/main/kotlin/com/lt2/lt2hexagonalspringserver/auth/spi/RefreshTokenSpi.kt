package com.lt2.lt2hexagonalspringserver.auth.spi

import com.lt2.lt2hexagonalspringserver.annotation.Spi

@Spi
interface RefreshTokenSpi: RefreshTokenSaveSpi, RefreshTokenUpdateSpi {
}