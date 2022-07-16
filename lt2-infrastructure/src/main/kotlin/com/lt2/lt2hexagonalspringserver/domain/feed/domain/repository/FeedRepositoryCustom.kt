package com.lt2.lt2hexagonalspringserver.domain.feed.domain.repository

import com.lt2.lt2hexagonalspringserver.feed.api.dto.respons.FeedResponse

interface FeedRepositoryCustom {
    fun findAll(page: Int): List<FeedResponse>
}
