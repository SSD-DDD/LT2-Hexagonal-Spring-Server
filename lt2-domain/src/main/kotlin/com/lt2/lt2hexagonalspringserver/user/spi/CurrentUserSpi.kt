package com.lt2.lt2hexagonalspringserver.user.spi

import java.util.*

interface CurrentUserSpi {
    fun currentUserId(): UUID
}