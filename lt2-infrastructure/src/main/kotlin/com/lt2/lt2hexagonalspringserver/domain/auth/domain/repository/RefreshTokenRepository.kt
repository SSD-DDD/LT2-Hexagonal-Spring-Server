package com.lt2.lt2hexagonalspringserver.domain.auth.domain.repository

import com.lt2.lt2hexagonalspringserver.domain.auth.domain.RefreshTokenEntity
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository: CrudRepository<RefreshTokenEntity, String> {
}