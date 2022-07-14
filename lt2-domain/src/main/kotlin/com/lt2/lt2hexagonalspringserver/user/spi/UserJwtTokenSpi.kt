package user.spi

import annotation.Spi
import user.spi.dto.SpiTokenResponse

@Spi
interface UserJwtTokenSpi {
    fun getToken(accountId: String): SpiTokenResponse
}