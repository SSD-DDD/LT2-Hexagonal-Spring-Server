package com.lt2.lt2hexagonalspringserver.comment.service

import com.lt2.lt2hexagonalspringserver.annotation.DomainService
import com.lt2.lt2hexagonalspringserver.comment.api.UpdateCommentApi
import com.lt2.lt2hexagonalspringserver.comment.api.dto.request.UpdateCommentDomainRequest
import com.lt2.lt2hexagonalspringserver.comment.spi.QueryCommentSpi
import java.util.*

@DomainService
class UpdateCommentApiImpl(
    private val queryCommentSpi: QueryCommentSpi
): UpdateCommentApi {

    override fun execute(commentId: UUID, request: UpdateCommentDomainRequest) =
        queryCommentSpi.updateComment(commentId, request)
}