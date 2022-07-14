package com.lt2.lt2hexagonalspringserver.domain.comment.domain

import com.lt2.lt2hexagonalspringserver.domain.feed.domain.FeedEntity
import com.lt2.lt2hexagonalspringserver.domain.user.domain.UserEntity
import com.lt2.lt2hexagonalspringserver.global.entity.BaseTimeEntity
import java.util.*
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Table(name = "tbl_comment")
@Entity
class CommentEntity(

    override val id: UUID,

    content: String,

    userEntity: UserEntity,

    feedEntity: FeedEntity

): BaseTimeEntity() {

    var content = content
        protected set

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    var userEntity = userEntity
        protected set

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "feed_id")
    var feedEntity = feedEntity
        protected set
}