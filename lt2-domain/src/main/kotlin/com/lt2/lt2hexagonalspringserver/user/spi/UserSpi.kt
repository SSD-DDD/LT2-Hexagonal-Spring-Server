package com.lt2.lt2hexagonalspringserver.user.spi

import com.lt2.lt2hexagonalspringserver.annotation.Spi

@Spi
interface UserSpi: QueryUserSpi, CurrentUserSpi {
}