package user

import annotation.Aggregate
import user.type.Role
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