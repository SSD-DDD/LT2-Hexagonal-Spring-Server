package com.lt2.lt2hexagonalspringserver.domain.user.domain

import com.lt2.lt2hexagonalspringserver.global.entity.BaseUUIDEntity
import org.jetbrains.annotations.NotNull
import java.util.*
import javax.persistence.Entity
import javax.persistence.Table

@Table(name = "tbl_user")
@Entity
class UserEntity(

    override val id: UUID,

    accountId: String,

    password: String,

    name: String,

    money: Long

): BaseUUIDEntity() {

    @field:NotNull
    var accountId = accountId
        protected set

    @field:NotNull
    var password = password
        protected set

    @field:NotNull
    var name = name
        protected set

    @field:NotNull
    var money = money
        protected set
}