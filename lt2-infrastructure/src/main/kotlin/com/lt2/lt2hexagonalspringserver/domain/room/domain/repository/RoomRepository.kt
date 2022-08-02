package com.lt2.lt2hexagonalspringserver.domain.room.domain.repository

import com.lt2.lt2hexagonalspringserver.domain.room.domain.RoomEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface RoomRepository: CrudRepository<RoomEntity, UUID>{
}