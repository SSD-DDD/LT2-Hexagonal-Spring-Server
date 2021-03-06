package com.lt2.lt2hexagonalspringserver.feed.spi

import com.lt2.lt2hexagonalspringserver.annotation.Spi
import com.lt2.lt2hexagonalspringserver.feed.Feed
import com.lt2.lt2hexagonalspringserver.feed.api.dto.request.UpdateFeedDomainRequest
import com.lt2.lt2hexagonalspringserver.feed.api.dto.response.FeedResponse
import java.util.UUID

@Spi
interface QueryFeedSpi {
    fun saveFeed(feed: Feed)

    fun findById(feedId: UUID): Feed
    fun findAll(page: Int): List<FeedResponse>
    fun updateFeed(feedId: UUID, request: UpdateFeedDomainRequest)
    fun deleteFeed(feed: Feed)
}