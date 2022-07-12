package com.lt2.lt2hexagonalspringserver.domain.feed.persistence.repository

import com.lt2.lt2hexagonalspringserver.domain.feed.persistence.entity.FeedEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface FeedRepository: CrudRepository<FeedEntity, UUID> {
}