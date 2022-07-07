package com.lt2.lt2hexagonalspringserver.domain.user.presentation.entity

import com.lt2.lt2hexagonalspringserver.global.entity.BaseUUIDEntity
import org.jetbrains.annotations.NotNull
import javax.persistence.Entity
import javax.persistence.Table

@Table(name = "tbl_user")
@Entity
class UserEntity(

    @field:NotNull
    val accountId: String,

    @field:NotNull
    val password: String,

    @field:NotNull
    val name: String

): BaseUUIDEntity()