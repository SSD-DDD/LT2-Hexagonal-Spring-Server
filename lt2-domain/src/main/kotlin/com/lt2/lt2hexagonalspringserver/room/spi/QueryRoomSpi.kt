package com.lt2.lt2hexagonalspringserver.room.spi

import com.lt2.lt2hexagonalspringserver.room.api.dto.response.RoomListResponse

interface QueryRoomSpi {
    fun findAll(): RoomListResponse
}