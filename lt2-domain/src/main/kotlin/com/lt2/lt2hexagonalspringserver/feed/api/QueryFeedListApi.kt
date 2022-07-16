package com.lt2.lt2hexagonalspringserver.feed.api

import com.lt2.lt2hexagonalspringserver.feed.api.dto.respons.FeedResponse

interface QueryFeedListApi {
    fun execute(page: Int): List<FeedResponse>
}