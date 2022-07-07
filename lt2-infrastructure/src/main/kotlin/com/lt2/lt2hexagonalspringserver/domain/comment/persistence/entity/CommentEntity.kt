package com.lt2.lt2hexagonalspringserver.domain.comment.persistence.entity

import com.lt2.lt2hexagonalspringserver.domain.feed.persistence.entity.FeedEntity
import com.lt2.lt2hexagonalspringserver.domain.user.presentation.entity.UserEntity
import com.lt2.lt2hexagonalspringserver.global.entity.BaseTimeEntity
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Table(name = "tbl_comment")
@Entity
class CommentEntity(

    val content: String,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    val userEntity: UserEntity,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "feed_id")
    val feedEntity: FeedEntity

): BaseTimeEntity()