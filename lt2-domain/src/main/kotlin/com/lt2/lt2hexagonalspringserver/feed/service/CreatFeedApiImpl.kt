package com.lt2.lt2hexagonalspringserver.feed.service

import com.lt2.lt2hexagonalspringserver.annotation.DomainService
import com.lt2.lt2hexagonalspringserver.feed.Feed
import com.lt2.lt2hexagonalspringserver.feed.api.CreateFeedApi
import com.lt2.lt2hexagonalspringserver.feed.api.dto.request.CreateFeedDomainRequest
import com.lt2.lt2hexagonalspringserver.feed.spi.QueryFeedSpi
import com.lt2.lt2hexagonalspringserver.user.spi.CurrentUserSpi
import java.util.*

@DomainService
class CreatFeedApiImpl(
    private val queryFeedSpi: QueryFeedSpi,
    private val currentUserSpi: CurrentUserSpi
): CreateFeedApi {

    override fun execute(request: CreateFeedDomainRequest) {
        queryFeedSpi.saveFeed(request.toFeed())
    }

    private fun CreateFeedDomainRequest.toFeed() =
        Feed(
            id = UUID(0, 0),
            title = title,
            content = content,
            userId = currentUserSpi.currentUserId()
        )
}