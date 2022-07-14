package com.lt2.lt2hexagonalspringserver.user.spi

import com.lt2.lt2hexagonalspringserver.annotation.Spi
import com.lt2.lt2hexagonalspringserver.user.User

@Spi
interface QueryUserSpi {
    fun saveUser(user: User)
    fun checkUserExistsByAccountId(accountId: String)
    fun findByAccountId(accountId: String): User
}
