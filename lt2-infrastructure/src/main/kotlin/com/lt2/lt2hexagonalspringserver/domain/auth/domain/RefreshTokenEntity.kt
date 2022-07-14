package com.lt2.lt2hexagonalspringserver.domain.auth.domain

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed

@RedisHash
class RefreshTokenEntity(

    accountId: String,

    token: String,

    ttl: Long
) {

    @Id
    var accountId = accountId
        private set

    @Indexed
    var token = token
        private set

    @TimeToLive
    var ttl = ttl
        private set

    fun updateRefreshToken(token: String, ttl: Long) {
        this.token = token
        this.ttl = ttl
    }
}