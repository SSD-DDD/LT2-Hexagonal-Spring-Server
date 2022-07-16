package com.lt2.lt2hexagonalspringserver.domain.feed.domain.repository

import com.lt2.lt2hexagonalspringserver.domain.feed.domain.FeedEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface FeedRepository: CrudRepository<FeedEntity, UUID>, FeedRepositoryCustom {
}