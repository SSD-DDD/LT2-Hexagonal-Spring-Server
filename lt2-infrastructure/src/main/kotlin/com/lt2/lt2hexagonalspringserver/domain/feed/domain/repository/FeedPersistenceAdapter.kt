package com.lt2.lt2hexagonalspringserver.domain.feed.domain.repository

import com.lt2.lt2hexagonalspringserver.domain.feed.mapper.FeedMapper
import com.lt2.lt2hexagonalspringserver.global.annotation.Adapter
import com.lt2.lt2hexagonalspringserver.feed.Feed
import com.lt2.lt2hexagonalspringserver.feed.exception.FeedNotFoundException
import com.lt2.lt2hexagonalspringserver.feed.spi.FeedSpi
import org.springframework.data.repository.findByIdOrNull
import java.util.UUID

@Adapter
class FeedPersistenceAdapter(
    private val feedRepository: FeedRepository,
    private val feedMapper: FeedMapper
): FeedSpi {

    override fun saveFeed(feed: Feed) {
        val feedEntity = feedMapper.feedDomainToEntity(feed)
        feedRepository.save(feedEntity)
    }

    fun findById(id: UUID): Feed {
        val feedEntity = jpaFeedById(id)
        return feedMapper.feedEntityToDomain(feedEntity)
    }

    private fun jpaFeedById(id: UUID) =
        feedRepository.findByIdOrNull(id) ?: throw FeedNotFoundException
}