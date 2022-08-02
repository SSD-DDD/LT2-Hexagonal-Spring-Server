package com.lt2.lt2hexagonalspringserver.room.api

import com.lt2.lt2hexagonalspringserver.room.api.dto.response.RoomListResponse

interface GetRoomListApi {
    fun execute(): RoomListResponse
}