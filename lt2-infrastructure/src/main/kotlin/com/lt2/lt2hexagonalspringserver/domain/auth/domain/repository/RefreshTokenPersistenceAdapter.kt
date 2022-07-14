package com.lt2.lt2hexagonalspringserver.domain.auth.domain.repository

import auth.RefreshToken
import auth.exception.RefreshTokenNotFoundException
import auth.spi.RefreshTokenSpi
import com.lt2.lt2hexagonalspringserver.domain.auth.mapper.RefreshTokenMapper
import com.lt2.lt2hexagonalspringserver.global.annotation.Adapter
import com.lt2.lt2hexagonalspringserver.global.security.jwt.JwtProperties
import org.springframework.transaction.annotation.Transactional
import user.api.dto.response.TokenDomainResponse
import user.spi.UserJwtTokenSpi
import user.spi.dto.SpiTokenResponse

@Adapter
class RefreshTokenPersistenceAdapter(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val refreshTokenMapper: RefreshTokenMapper
): RefreshTokenSpi {

    override fun saveRefreshToken(refreshToken: RefreshToken) {
        val refreshTokenEntity = refreshTokenMapper.refreshTokenDomainToEntity(refreshToken)
        refreshTokenRepository.save(refreshTokenEntity)
    }

    fun jpaRefreshTokenByToken(token: String) =
        refreshTokenRepository.findByToken(token) ?: throw RefreshTokenNotFoundException
}