package com.lt2.lt2hexagonalspringserver.comment.service

import com.lt2.lt2hexagonalspringserver.annotation.DomainService
import com.lt2.lt2hexagonalspringserver.comment.Comment
import com.lt2.lt2hexagonalspringserver.comment.api.CreateCommentApi
import com.lt2.lt2hexagonalspringserver.comment.api.dto.request.CreateCommentDomainRequest
import com.lt2.lt2hexagonalspringserver.comment.spi.QueryCommentSpi
import com.lt2.lt2hexagonalspringserver.user.spi.CurrentUserSpi
import java.util.*

@DomainService
class CreateCommentApiImpl(
    private val queryCommentSpi: QueryCommentSpi,
    private val currentUserSpi: CurrentUserSpi
): CreateCommentApi {

    override fun execute(feedId: UUID, request: CreateCommentDomainRequest) {
        val comment = Comment(
            commentId = UUID(0, 0),
            content = request.content,
            feedId = feedId,
            userId = currentUserSpi.currentUser().id
        )

        queryCommentSpi.saveComment(comment)
    }
}