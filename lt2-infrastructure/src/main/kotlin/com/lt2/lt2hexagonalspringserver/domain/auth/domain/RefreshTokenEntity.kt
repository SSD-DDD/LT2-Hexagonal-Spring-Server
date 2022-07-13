package com.lt2.lt2hexagonalspringserver.domain.auth.domain

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed

@RedisHash
class RefreshTokenEntity(

    @Id
    val accountId: String,

    @Indexed
    val token: String,

    @TimeToLive
    val ttl: Long
)