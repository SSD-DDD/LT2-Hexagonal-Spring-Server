package com.lt2.lt2hexagonalspringserver.domain.comment.domain.repository

import com.lt2.lt2hexagonalspringserver.comment.spi.CommentSpi
import com.lt2.lt2hexagonalspringserver.global.annotation.Adapter

@Adapter
class CommentPersistenceAdapter(
    private val commentRepository: CommentRepository
): CommentSpi {


}