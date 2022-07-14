package com.lt2.lt2hexagonalspringserver.domain.feed.mapper

import com.lt2.lt2hexagonalspringserver.domain.feed.domain.FeedEntity
import feed.Feed

interface FeedMapper {
    fun feedDomainToEntity(feed: Feed): FeedEntity
    fun feedEntityToDomain(feedEntity: FeedEntity): Feed
}