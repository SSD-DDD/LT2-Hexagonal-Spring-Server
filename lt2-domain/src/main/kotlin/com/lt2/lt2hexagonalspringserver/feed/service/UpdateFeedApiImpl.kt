package com.lt2.lt2hexagonalspringserver.feed.service

import com.lt2.lt2hexagonalspringserver.annotation.DomainService
import com.lt2.lt2hexagonalspringserver.feed.api.UpdateFeedApi
import com.lt2.lt2hexagonalspringserver.feed.api.dto.request.UpdateFeedDomainRequest
import com.lt2.lt2hexagonalspringserver.feed.spi.FeedSpi
import com.lt2.lt2hexagonalspringserver.feed.spi.QueryFeedSpi
import java.util.*

@DomainService
class UpdateFeedApiImpl(
    private val queryFeedSpi: QueryFeedSpi
): UpdateFeedApi {

    override fun execute(feedId: UUID, request: UpdateFeedDomainRequest) {
        queryFeedSpi.updateFeed(feedId, request)
    }
}