package com.lt2.lt2hexagonalspringserver.domain.room.domain.repository

import com.lt2.lt2hexagonalspringserver.global.annotation.Adapter
import com.lt2.lt2hexagonalspringserver.room.api.dto.response.RoomListResponse
import com.lt2.lt2hexagonalspringserver.room.spi.RoomSpi

@Adapter
class RoomPersistenceAdapter(
    private val roomRepository: RoomRepository
): RoomSpi {

    override fun findAll(): RoomListResponse {
        val roomList = roomRepository.findAll().map {
            RoomListResponse.RoomResponse(
                roomId = it.id,
                title = it.title
            )
        }

        return RoomListResponse(roomList)
    }

}