package com.lt2.lt2hexagonalspringserver.domain.auth.mapper

import auth.RefreshToken
import com.lt2.lt2hexagonalspringserver.domain.auth.domain.RefreshTokenEntity

interface RefreshTokenMapper {
    fun refreshTokenDomainToEntity(refreshToken: RefreshToken): RefreshTokenEntity
    fun refreshTokenEntityToDomain(refreshTokenEntity: RefreshTokenEntity): RefreshToken
}