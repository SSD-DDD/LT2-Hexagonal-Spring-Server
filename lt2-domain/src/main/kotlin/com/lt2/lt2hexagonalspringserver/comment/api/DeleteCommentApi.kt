package com.lt2.lt2hexagonalspringserver.comment.api

import java.util.UUID

interface DeleteCommentApi {
    fun execute(commentId: UUID)
}