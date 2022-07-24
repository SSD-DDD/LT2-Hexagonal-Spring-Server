package com.lt2.lt2hexagonalspringserver.domain.feed.domain.repository.vo

import com.querydsl.core.annotations.QueryProjection
import java.time.ZonedDateTime
import java.util.UUID

data class FeedVO @QueryProjection constructor(

    val feedId: UUID,

    val title: String,

    val content: String,

    val userId: UUID,

    val createdAt: ZonedDateTime
)