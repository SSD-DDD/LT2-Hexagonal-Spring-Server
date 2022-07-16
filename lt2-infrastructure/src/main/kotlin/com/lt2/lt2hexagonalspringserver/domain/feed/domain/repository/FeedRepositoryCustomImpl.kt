package com.lt2.lt2hexagonalspringserver.domain.feed.domain.repository

import com.lt2.lt2hexagonalspringserver.domain.feed.domain.QFeedEntity.feedEntity
import com.lt2.lt2hexagonalspringserver.domain.feed.domain.repository.vo.QFeedVO
import com.lt2.lt2hexagonalspringserver.domain.user.domain.QUserEntity.userEntity
import com.lt2.lt2hexagonalspringserver.feed.api.dto.respons.FeedResponse
import com.querydsl.jpa.impl.JPAQueryFactory

class FeedRepositoryCustomImpl(
    private val jpaQueryFactory: JPAQueryFactory
): FeedRepositoryCustom {

    override fun findAll(page: Int): List<FeedResponse> {
        val size: Long = 10

        val feedVO = jpaQueryFactory
            .select(
                QFeedVO(
                    feedEntity.id,
                    feedEntity.title,
                    feedEntity.content,
                    userEntity.id,
                    feedEntity.createdAt
                )
            )
            .from(feedEntity)
            .join(feedEntity.userEntity, userEntity)
            .offset(page * size)
            .limit(size)
            .fetch()

        return feedVO.map {
            FeedResponse(
                feedId = it.feedId,
                title = it.title,
                content = it.content,
                userId = it.userId,
                createAt = it.createAt
            )
        }.toList()
    }
}