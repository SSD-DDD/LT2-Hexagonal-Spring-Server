package com.lt2.lt2hexagonalspringserver.domain.user.mapper

import com.lt2.lt2hexagonalspringserver.domain.user.domain.UserEntity
import org.springframework.stereotype.Component
import user.User

@Component
class UserMapperImpl: UserMapper {

    override fun userDomainToEntity(user: User) =
        UserEntity(
            id = user.id,
            accountId = user.accountId,
            password = user.password,
            name = user.name,
            money = user.money
        )

    override fun userEntityToDomain(userEntity: UserEntity) =
        User(
            id = userEntity.id,
            accountId = userEntity.accountId,
            password = userEntity.password,
            name = userEntity.name,
            money = userEntity.money
        )
}