package com.lt2.lt2hexagonalspringserver.domain.user.mapper

import com.lt2.lt2hexagonalspringserver.domain.user.domain.UserEntity
import user.User

interface UserMapper {
    fun userDomainToEntity(user: User): UserEntity

    fun userEntityToDomain(userEntity: UserEntity): User
}