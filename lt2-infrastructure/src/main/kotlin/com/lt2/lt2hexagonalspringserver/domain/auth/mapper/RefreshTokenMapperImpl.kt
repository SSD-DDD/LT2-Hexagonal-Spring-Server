package com.lt2.lt2hexagonalspringserver.domain.auth.mapper

import com.lt2.lt2hexagonalspringserver.auth.RefreshToken
import com.lt2.lt2hexagonalspringserver.domain.auth.domain.RefreshTokenEntity
import org.springframework.stereotype.Component

@Component
class RefreshTokenMapperImpl: RefreshTokenMapper {

    override fun refreshTokenDomainToEntity(refreshToken: RefreshToken) =
        RefreshTokenEntity(
            accountId = refreshToken.accountId,
            token = refreshToken.token,
            ttl = refreshToken.ttl
        )

    override fun refreshTokenEntityToDomain(refreshTokenEntity: RefreshTokenEntity) =
        RefreshToken(
            accountId = refreshTokenEntity.accountId,
            token = refreshTokenEntity.token,
            ttl = refreshTokenEntity.ttl
        )
}