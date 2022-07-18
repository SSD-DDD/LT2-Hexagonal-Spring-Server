package com.lt2.lt2hexagonalspringserver.comment.api

import com.lt2.lt2hexagonalspringserver.comment.api.dto.request.CreateCommentDomainRequest
import java.util.*

interface CreateCommentApi {
    fun execute(feedId: UUID, request: CreateCommentDomainRequest)
}