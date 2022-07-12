package com.lt2.lt2hexagonalspringserver.domain.user.domain.repository

import user.User

interface UserRepositorySpi {
    fun saveUser(user: User)
}
