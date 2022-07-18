package com.lt2.lt2hexagonalspringserver.feed.api

import java.util.UUID

interface DeleteFeedApi {
    fun execute(feedId: UUID)
}