package com.lt2.lt2hexagonalspringserver.domain.auth.domain.repository

import auth.RefreshToken
import auth.spi.RefreshTokenSaveSpi
import auth.spi.RefreshTokenSpi
import com.lt2.lt2hexagonalspringserver.domain.auth.mapper.RefreshTokenMapper
import com.lt2.lt2hexagonalspringserver.global.annotation.Adapter

@Adapter
class RefreshTokenPersistenceAdapter(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val refreshTokenMapper: RefreshTokenMapper
): RefreshTokenSpi {

    override fun saveRefreshToken(refreshToken: RefreshToken) {
        val refreshTokenEntity = refreshTokenMapper.refreshTokenDomainToEntity(refreshToken)
        refreshTokenRepository.save(refreshTokenEntity)
    }
}