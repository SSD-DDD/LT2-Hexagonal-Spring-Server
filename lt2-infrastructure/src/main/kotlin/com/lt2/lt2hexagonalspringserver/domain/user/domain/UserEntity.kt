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

    @field:NotNull
    val accountId: String,

    @field:NotNull
    val password: String,

    @field:NotNull
    val name: String,

    val money: Long

): BaseUUIDEntity() {

}