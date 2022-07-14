package com.lt2.lt2hexagonalspringserver.user.spi

import com.lt2.lt2hexagonalspringserver.user.User

interface CurrentUserSpi {
    fun currentUser(): User
}