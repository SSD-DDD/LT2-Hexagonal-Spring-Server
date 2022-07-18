package com.lt2.lt2hexagonalspringserver.domain.feed.mapper

import com.lt2.lt2hexagonalspringserver.domain.feed.domain.FeedEntity
import com.lt2.lt2hexagonalspringserver.domain.user.domain.repository.UserRepository
import com.lt2.lt2hexagonalspringserver.feed.Feed
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import com.lt2.lt2hexagonalspringserver.user.exception.UserNotFoundException
import java.util.UUID

@Component
class FeedMapperImpl(
    private val userRepository: UserRepository
): FeedMapper {

    override fun feedDomainToEntity(feed: Feed) =
        FeedEntity(
            id = feed.feedId,
            title = feed.title,
            content = feed.content,
            userEntity = findByUserId(feed.userId)
        )

    override fun feedEntityToDomain(feedEntity: FeedEntity) =
        Feed(
            feedId = feedEntity.id,
            title = feedEntity.title,
            content = feedEntity.content,
            userId = feedEntity.userEntity.id
        )

    private fun findByUserId(id: UUID) =
        userRepository.findByIdOrNull(id) ?: throw UserNotFoundException
}