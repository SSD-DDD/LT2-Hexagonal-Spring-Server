package com.lt2.lt2hexagonalspringserver.domain.room.mapper

import com.lt2.lt2hexagonalspringserver.domain.room.domain.RoomEntity
import com.lt2.lt2hexagonalspringserver.room.Room

interface RoomMapper {
    fun roomDomainToEntity(room: Room): RoomEntity
    fun roomEntityToDomain(roomEntity: RoomEntity): Room
}