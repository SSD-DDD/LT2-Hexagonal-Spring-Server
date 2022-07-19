package com.lt2.lt2hexagonalspringserver.comment.service

import com.lt2.lt2hexagonalspringserver.annotation.DomainService
import com.lt2.lt2hexagonalspringserver.comment.api.DeleteCommentApi
import com.lt2.lt2hexagonalspringserver.comment.spi.QueryCommentSpi
import java.util.*

@DomainService
class DeleteCommentApiImpl(
    private val queryCommentSpi: QueryCommentSpi
): DeleteCommentApi {

    override fun execute(commentId: UUID) = queryCommentSpi.deleteComment(commentId)
}