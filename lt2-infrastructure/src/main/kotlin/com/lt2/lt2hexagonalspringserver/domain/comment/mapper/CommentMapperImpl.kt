package com.lt2.lt2hexagonalspringserver.domain.comment.mapper

import com.lt2.lt2hexagonalspringserver.comment.Comment
import com.lt2.lt2hexagonalspringserver.domain.comment.domain.CommentEntity
import com.lt2.lt2hexagonalspringserver.domain.feed.domain.repository.FeedRepository
import com.lt2.lt2hexagonalspringserver.domain.user.domain.repository.UserRepository
import com.lt2.lt2hexagonalspringserver.feed.exception.FeedNotFoundException
import com.lt2.lt2hexagonalspringserver.user.exception.UserNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class CommentMapperImpl(
    private val feedRepository: FeedRepository,
    private val userRepository: UserRepository
): CommentMapper {

    override fun commentDomainToEntity(comment: Comment) =
        CommentEntity(
            id = comment.commentId,
            content = comment.content,
            feedEntity = findByFeedId(comment.feedId),
            userEntity = findByUserId(comment.userId)
        )

    override fun commentEntityToDomain(commentEntity: CommentEntity) =
        Comment(
            commentId = commentEntity.id,
            content = commentEntity.content,
            feedId = commentEntity.feedEntity.id,
            userId = commentEntity.userEntity.id
        )

    private fun findByFeedId(feedId: UUID) =
        feedRepository.findByIdOrNull(feedId) ?: throw FeedNotFoundException

    private fun findByUserId(userId: UUID) =
        userRepository.findByIdOrNull(userId) ?: throw UserNotFoundException
}