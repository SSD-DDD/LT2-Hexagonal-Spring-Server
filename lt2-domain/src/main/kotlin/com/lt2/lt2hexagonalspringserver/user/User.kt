package com.lt2.lt2hexagonalspringserver.user

import com.lt2.lt2hexagonalspringserver.annotation.Aggregate
import com.lt2.lt2hexagonalspringserver.user.type.Role
import java.util.UUID

@Aggregate
class User(

    val id: UUID,

    val accountId: String,

    val password: String,

    val name: String,

    val money: Long,

    val role: Role
)