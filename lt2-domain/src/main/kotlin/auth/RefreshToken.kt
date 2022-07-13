package auth

import annotation.Aggregate

@Aggregate
class RefreshToken(

    val accountId: String,

    val token: String,

    val ttl: Long
)