package com.lt2.lt2hexagonalspringserver.room

import com.lt2.lt2hexagonalspringserver.annotation.Aggregate
import java.util.UUID

@Aggregate
class Room(

    val roomId: UUID,

    val title: String
)