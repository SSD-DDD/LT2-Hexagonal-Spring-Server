package com.lt2.lt2hexagonalspringserver.feed.api.dto.respons

import com.lt2.lt2hexagonalspringserver.comment.api.dto.response.CommentResponse
import java.time.ZonedDateTime
import java.util.UUID

data class FeedResponse(

    val feedId: UUID,

    val title: String,

    val content: String,

    val userId: UUID,

    val createdAt: ZonedDateTime,

    val comments: List<CommentResponse>
)