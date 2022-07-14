package com.lt2.lt2hexagonalspringserver.auth

import com.lt2.lt2hexagonalspringserver.annotation.Aggregate

@Aggregate
class RefreshToken(

    val accountId: String,

    val token: String,

    val ttl: Long
)