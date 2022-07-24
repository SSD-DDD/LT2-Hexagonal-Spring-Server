package com.lt2.lt2hexagonalspringserver.domain.feed.domain.repository

import com.lt2.lt2hexagonalspringserver.feed.api.dto.response.FeedResponse

interface FeedRepositoryCustom {
    fun findAllAsc(page: Int): List<FeedResponse>
}
