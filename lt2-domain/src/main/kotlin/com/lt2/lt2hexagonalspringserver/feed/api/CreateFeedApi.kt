package com.lt2.lt2hexagonalspringserver.feed.api

import com.lt2.lt2hexagonalspringserver.feed.api.dto.request.CreateFeedDomainRequest

interface CreateFeedApi {
    fun execute(request: CreateFeedDomainRequest)
}