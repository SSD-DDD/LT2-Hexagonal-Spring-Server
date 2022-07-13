package com.lt2.lt2hexagonalspringserver.domain.auth.domain.repository

import auth.RefreshToken
import auth.spi.CreateRefreshTokenSpi
import com.lt2.lt2hexagonalspringserver.domain.auth.mapper.RefreshTokenMapper
import com.lt2.lt2hexagonalspringserver.global.annotation.Adapter
import com.lt2.lt2hexagonalspringserver.global.security.jwt.JwtTokenProvider

@Adapter
class RefreshTokenPersistenceAdapter(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val refreshTokenMapper: RefreshTokenMapper,
    private val jwtTokenProvider: JwtTokenProvider
): CreateRefreshTokenSpi {

    fun saveRefreshToken(refreshToken: RefreshToken) {
        val refreshTokenEntity = refreshTokenMapper.refreshTokenDomainToEntity(refreshToken)
        refreshTokenRepository.save(refreshTokenEntity)
    }

    override fun generateRefreshToken(accountId: String) = jwtTokenProvider.generateRefreshToken(accountId)
}