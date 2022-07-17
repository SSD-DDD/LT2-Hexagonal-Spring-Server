package com.lt2.lt2hexagonalspringserver.feed.api

import com.lt2.lt2hexagonalspringserver.feed.api.dto.request.UpdateFeedDomainRequest
import java.util.UUID

interface UpdateFeedApi {
    fun execute(feedId: UUID, request: UpdateFeedDomainRequest)
}