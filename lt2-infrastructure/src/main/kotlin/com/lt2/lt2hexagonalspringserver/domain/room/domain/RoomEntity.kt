package com.lt2.lt2hexagonalspringserver.domain.room

import com.lt2.lt2hexagonalspringserver.global.entity.BaseTimeEntity
import java.util.*
import javax.persistence.Entity
import javax.persistence.Table

@Table(name = "tbl_room")
@Entity
class RoomEntity(

    override val id: UUID,


): BaseTimeEntity() {

}