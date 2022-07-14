package com.lt2.lt2hexagonalspringserver.domain.feed.domain

import com.lt2.lt2hexagonalspringserver.domain.user.domain.UserEntity
import com.lt2.lt2hexagonalspringserver.global.entity.BaseTimeEntity
import org.jetbrains.annotations.NotNull
import java.util.*
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Table(name = "tbl_feed")
@Entity
class FeedEntity(

    override val id: UUID,

    title: String,

    content: String,

    userEntity: UserEntity

):BaseTimeEntity() {

    @field:NotNull
    var title = title
        protected set

    @field:NotNull
    var content = content
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var userEntity = userEntity
        protected set
}