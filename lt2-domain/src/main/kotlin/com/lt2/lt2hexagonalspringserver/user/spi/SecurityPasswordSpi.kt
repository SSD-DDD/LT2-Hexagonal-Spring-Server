package com.lt2.lt2hexagonalspringserver.user.spi

import com.lt2.lt2hexagonalspringserver.annotation.Spi

@Spi
interface SecurityPasswordSpi {
    fun passwordEncode(password: String): String
    fun passwordMatch(rawPassword: String, encodedPassword: String): Boolean
}