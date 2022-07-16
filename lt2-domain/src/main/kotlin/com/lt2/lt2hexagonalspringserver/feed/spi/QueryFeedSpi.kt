package com.lt2.lt2hexagonalspringserver.feed.spi

import com.lt2.lt2hexagonalspringserver.annotation.Spi
import com.lt2.lt2hexagonalspringserver.feed.Feed
import com.lt2.lt2hexagonalspringserver.feed.api.dto.respons.FeedResponse

@Spi
interface QueryFeedSpi {
    fun saveFeed(feed: Feed)
    fun findAll(page: Int): List<FeedResponse>
}