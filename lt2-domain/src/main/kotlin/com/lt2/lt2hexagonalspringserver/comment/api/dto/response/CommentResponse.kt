package com.lt2.lt2hexagonalspringserver.comment.api.dto.response

import java.time.ZonedDateTime
import java.util.UUID

data class CommentResponse(

    val commentId: UUID,

    val feedId: UUID,

    val userId: UUID,

    val content: String,

    val createdAt: ZonedDateTime
)
