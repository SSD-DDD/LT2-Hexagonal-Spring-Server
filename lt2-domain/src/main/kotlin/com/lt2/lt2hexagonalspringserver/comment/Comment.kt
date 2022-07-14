package com.lt2.lt2hexagonalspringserver.comment

import com.lt2.lt2hexagonalspringserver.annotation.Aggregate
import java.util.UUID

@Aggregate
class Comment(

    val id: UUID,

    val userId: UUID,

    val feedId: UUID
)