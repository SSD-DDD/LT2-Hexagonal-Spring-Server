package com.lt2.lt2hexagonalspringserver.feed.service

import com.lt2.lt2hexagonalspringserver.annotation.DomainService
import com.lt2.lt2hexagonalspringserver.feed.api.QueryFeedListApi
import com.lt2.lt2hexagonalspringserver.feed.spi.QueryFeedSpi

@DomainService
class QueryFeedListApiImpl(
    private val queryFeedSpi: QueryFeedSpi
): QueryFeedListApi {

    override fun execute(page: Int) = queryFeedSpi.findAll(page)
}