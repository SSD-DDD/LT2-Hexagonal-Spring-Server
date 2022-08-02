package com.lt2.lt2hexagonalspringserver.domain.feed.domain.repository

import com.lt2.lt2hexagonalspringserver.comment.api.dto.response.CommentResponse
import com.lt2.lt2hexagonalspringserver.domain.comment.domain.QCommentEntity.commentEntity
import com.lt2.lt2hexagonalspringserver.domain.comment.domain.repository.vo.QCommentVO
import com.lt2.lt2hexagonalspringserver.domain.feed.domain.QFeedEntity.feedEntity
import com.lt2.lt2hexagonalspringserver.domain.feed.domain.repository.vo.QFeedVO
import com.lt2.lt2hexagonalspringserver.domain.user.domain.QUserEntity.userEntity
import com.lt2.lt2hexagonalspringserver.feed.api.dto.response.FeedResponse
import com.querydsl.jpa.impl.JPAQueryFactory
import java.util.UUID

class FeedRepositoryCustomImpl(
    private val jpaQueryFactory: JPAQueryFactory
): FeedRepositoryCustom {

    override fun findAllAsc(page: Int): List<FeedResponse> {
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
            .orderBy(feedEntity.createdAt.asc())
            .offset(page * size)
            .limit(size)
            .fetch()

        val feedResponse = feedVO.map { feed ->

            FeedResponse(
                feedId = feed.feedId,
                title = feed.title,
                content = feed.content,
                userId = feed.userId,
                createdAt = feed.createdAt,
                comments = findCommentsByFeedId(feed.feedId).map { comment ->
                    CommentResponse(
                        commentId = comment.commentId,
                        feedId = comment.feedId,
                        userId = comment.userId,
                        content = comment.content,
                        createdAt = comment.createdAt
                    )
                }
            )
        }

        return feedResponse
    }

    private fun findCommentsByFeedId(feedId: UUID) =
        jpaQueryFactory
            .select(
                QCommentVO(
                    commentEntity.id,
                    feedEntity.id,
                    userEntity.id,
                    commentEntity.content,
                    commentEntity.createdAt
                )
            )
            .from(commentEntity)
            .join(commentEntity.feedEntity, feedEntity)
            .join(commentEntity.userEntity, userEntity)
            .where(feedEntity.id.eq(feedId))
            .orderBy(commentEntity.createdAt.asc())
            .fetch()
}

