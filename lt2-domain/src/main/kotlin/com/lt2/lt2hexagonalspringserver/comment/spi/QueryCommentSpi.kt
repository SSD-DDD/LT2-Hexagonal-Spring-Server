package com.lt2.lt2hexagonalspringserver.comment.spi

import com.lt2.lt2hexagonalspringserver.annotation.Spi
import com.lt2.lt2hexagonalspringserver.comment.Comment
import com.lt2.lt2hexagonalspringserver.comment.api.dto.request.UpdateCommentDomainRequest
import java.util.*

@Spi
interface QueryCommentSpi {
    fun saveComment(comment: Comment)
    fun updateComment(commentId: UUID, request: UpdateCommentDomainRequest)
}