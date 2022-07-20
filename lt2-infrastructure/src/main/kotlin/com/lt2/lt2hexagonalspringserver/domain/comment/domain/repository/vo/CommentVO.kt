package com.lt2.lt2hexagonalspringserver.domain.comment.domain.repository.vo

import com.querydsl.core.annotations.QueryProjection
import java.time.ZonedDateTime
import java.util.UUID

data class CommentVO @QueryProjection constructor(

    val commentId: UUID,

    val feedId: UUID,

    val userId: UUID,

    val content: String,

    val createdAt: ZonedDateTime
)
