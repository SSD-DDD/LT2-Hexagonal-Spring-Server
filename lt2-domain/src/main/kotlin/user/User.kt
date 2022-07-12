package user

import annotation.Aggregate
import java.util.UUID

@Aggregate
class User(

    val id: UUID,

    val accountId: String,

    val password: String,

    val name: String,

    val money: Long
)