package com.lt2.lt2hexagonalspringserver.domain.room.mapper

import com.lt2.lt2hexagonalspringserver.domain.room.domain.RoomEntity
import com.lt2.lt2hexagonalspringserver.room.Room
import org.springframework.stereotype.Component

@Component
class RoomMapperImpl: RoomMapper {

    override fun roomDomainToEntity(room: Room) =
        RoomEntity(
            id = room.roomId,
            title = room.title
        )

    override fun roomEntityToDomain(roomEntity: RoomEntity) =
        Room(
            roomId = roomEntity.id,
            title = roomEntity.title
        )
}