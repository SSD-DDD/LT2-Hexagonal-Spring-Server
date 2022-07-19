package com.lt2.lt2hexagonalspringserver.comment.service

import com.lt2.lt2hexagonalspringserver.annotation.DomainService
import com.lt2.lt2hexagonalspringserver.comment.api.UpdateCommentApi
import com.lt2.lt2hexagonalspringserver.comment.api.dto.request.UpdateCommentDomainRequest
import java.util.*

@DomainService
class UpdateCommentApiImpl: UpdateCommentApi {

    override fun execute(feedId: UUID, request: UpdateCommentDomainRequest) {
        TODO("Not yet implemented")
    }
}