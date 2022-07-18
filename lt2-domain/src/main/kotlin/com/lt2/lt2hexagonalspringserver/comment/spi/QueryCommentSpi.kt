package com.lt2.lt2hexagonalspringserver.comment.spi

import com.lt2.lt2hexagonalspringserver.annotation.Spi
import com.lt2.lt2hexagonalspringserver.comment.Comment

@Spi
interface QueryCommentSpi {
    fun saveComment(comment: Comment)
}