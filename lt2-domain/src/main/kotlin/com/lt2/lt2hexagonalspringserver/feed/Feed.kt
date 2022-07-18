package com.lt2.lt2hexagonalspringserver.feed

import com.lt2.lt2hexagonalspringserver.annotation.Aggregate
import java.util.UUID

@Aggregate
class Feed(

    val feedId: UUID,

    val title: String,

    val content: String,

    val userId: UUID
)