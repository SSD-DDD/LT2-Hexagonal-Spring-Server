package com.lt2.lt2hexagonalspringserver.domain.feed.domain

import com.lt2.lt2hexagonalspringserver.domain.user.domain.UserEntity
import com.lt2.lt2hexagonalspringserver.global.entity.BaseTimeEntity
import org.jetbrains.annotations.NotNull
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Table(name = "tbl_feed")
@Entity
class FeedEntity(

    @field:NotNull
    val title: String,

    @field:NotNull
    val content: String,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    val userEntity: UserEntity

):BaseTimeEntity()