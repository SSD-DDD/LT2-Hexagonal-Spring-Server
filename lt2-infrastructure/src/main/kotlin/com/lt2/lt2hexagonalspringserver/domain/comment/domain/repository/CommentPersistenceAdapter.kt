package com.lt2.lt2hexagonalspringserver.domain.comment.domain.repository

import com.lt2.lt2hexagonalspringserver.comment.Comment
import com.lt2.lt2hexagonalspringserver.comment.spi.CommentSpi
import com.lt2.lt2hexagonalspringserver.domain.comment.mapper.CommentMapper
import com.lt2.lt2hexagonalspringserver.global.annotation.Adapter

@Adapter
class CommentPersistenceAdapter(
    private val commentRepository: CommentRepository,
    private val commentMapper: CommentMapper
): CommentSpi {

    override fun saveComment(comment: Comment) {
        val commentEntity = commentMapper.commentDomainToEntity(comment)
        commentRepository.save(commentEntity)
    }
}