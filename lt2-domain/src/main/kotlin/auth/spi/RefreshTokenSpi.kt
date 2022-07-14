package auth.spi

import annotation.Spi

@Spi
interface RefreshTokenSpi: RefreshTokenSaveSpi, RefreshTokenUpdateSpi {
}