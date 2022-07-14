package com.lt2.lt2hexagonalspringserver.feed.spi

import com.lt2.lt2hexagonalspringserver.annotation.Spi
import com.lt2.lt2hexagonalspringserver.feed.Feed

@Spi
interface QueryFeedSpi {
    fun saveFeed(feed: Feed)
}