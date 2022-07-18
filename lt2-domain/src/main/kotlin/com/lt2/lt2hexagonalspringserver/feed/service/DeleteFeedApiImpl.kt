package com.lt2.lt2hexagonalspringserver.feed.service

import com.lt2.lt2hexagonalspringserver.annotation.DomainService
import com.lt2.lt2hexagonalspringserver.feed.api.DeleteFeedApi
import com.lt2.lt2hexagonalspringserver.feed.spi.QueryFeedSpi
import java.util.*

@DomainService
class DeleteFeedApiImpl(
    private val queryFeedSpi: QueryFeedSpi
): DeleteFeedApi {

    override fun execute(feedId: UUID) = queryFeedSpi.deleteFeed(feedId)
}