package com.lt2.lt2hexagonalspringserver.global.entity

import java.time.ZonedDateTime
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseTimeEntity(
    
    val createdAt: ZonedDateTime = ZonedDateTime.now()
): BaseUUIDEntity()