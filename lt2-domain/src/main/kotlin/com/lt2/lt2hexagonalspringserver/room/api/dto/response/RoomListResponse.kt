package com.lt2.lt2hexagonalspringserver.room.api.dto.response

import java.util.UUID

data class RoomListResponse(
    val roomList: List<RoomResponse>
) {

    data class RoomResponse(
        val roomId: UUID,
        val title: String
    )
}
