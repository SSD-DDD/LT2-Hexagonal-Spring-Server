package com.lt2.lt2hexagonalspringserver.domain.auth.domain.repository

import com.lt2.lt2hexagonalspringserver.auth.RefreshToken
import com.lt2.lt2hexagonalspringserver.auth.exception.RefreshTokenNotFoundException
import com.lt2.lt2hexagonalspringserver.auth.spi.RefreshTokenSpi
import com.lt2.lt2hexagonalspringserver.domain.auth.mapper.RefreshTokenMapper
import com.lt2.lt2hexagonalspringserver.global.annotation.Adapter
import com.lt2.lt2hexagonalspringserver.global.security.jwt.JwtProperties
import org.springframework.transaction.annotation.Transactional
import com.lt2.lt2hexagonalspringserver.user.api.dto.response.TokenDomainResponse
import com.lt2.lt2hexagonalspringserver.user.spi.UserJwtTokenSpi
import com.lt2.lt2hexagonalspringserver.user.spi.dto.SpiTokenResponse

@Adapter
class RefreshTokenPersistenceAdapter(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val refreshTokenMapper: RefreshTokenMapper,
    private val jwtProperties: JwtProperties
): com.lt2.lt2hexagonalspringserver.auth.spi.RefreshTokenSpi {

    override fun saveRefreshToken(refreshToken: com.lt2.lt2hexagonalspringserver.auth.RefreshToken) {
        val refreshTokenEntity = refreshTokenMapper.refreshTokenDomainToEntity(refreshToken)
        refreshTokenRepository.save(refreshTokenEntity)
    }

    @Transactional
    override fun updateRefreshToken(token: String): com.lt2.lt2hexagonalspringserver.auth.RefreshToken {
        val refreshToken = findByToken(token)
        val refreshTokenEntity = refreshTokenMapper.refreshTokenDomainToEntity(refreshToken)
        refreshTokenEntity.updateRefreshToken(token, jwtProperties.refreshExp)
        return refreshTokenMapper.refreshTokenEntityToDomain(refreshTokenEntity)
    }

    fun findByToken(token: String): com.lt2.lt2hexagonalspringserver.auth.RefreshToken {
        val refreshTokenEntity = jpaRefreshTokenByToken(token)
        return refreshTokenMapper.refreshTokenEntityToDomain(refreshTokenEntity)
    }

    fun jpaRefreshTokenByToken(token: String) =
        refreshTokenRepository.findByToken(token) ?: throw com.lt2.lt2hexagonalspringserver.auth.exception.RefreshTokenNotFoundException
}