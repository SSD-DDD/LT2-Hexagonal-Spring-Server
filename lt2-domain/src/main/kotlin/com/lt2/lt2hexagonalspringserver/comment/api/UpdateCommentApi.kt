package com.lt2.lt2hexagonalspringserver.comment.api

import com.lt2.lt2hexagonalspringserver.comment.api.dto.request.UpdateCommentDomainRequest
import java.util.UUID

interface UpdateCommentApi {
    fun execute(commentId: UUID, request: UpdateCommentDomainRequest)
}