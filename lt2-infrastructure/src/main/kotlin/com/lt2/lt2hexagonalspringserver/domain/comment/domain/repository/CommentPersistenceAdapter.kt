package com.lt2.lt2hexagonalspringserver.domain.comment.domain.repository

import com.lt2.lt2hexagonalspringserver.comment.Comment
import com.lt2.lt2hexagonalspringserver.comment.api.dto.request.UpdateCommentDomainRequest
import com.lt2.lt2hexagonalspringserver.comment.exception.CommentNotFoundException
import com.lt2.lt2hexagonalspringserver.comment.spi.CommentSpi
import com.lt2.lt2hexagonalspringserver.domain.comment.mapper.CommentMapper
import com.lt2.lt2hexagonalspringserver.global.annotation.Adapter
import org.springframework.data.repository.findByIdOrNull
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Adapter
class CommentPersistenceAdapter(
    private val commentRepository: CommentRepository,
    private val commentMapper: CommentMapper
): CommentSpi {

    @Transactional
    override fun saveComment(comment: Comment) {
        val commentEntity = commentMapper.commentDomainToEntity(comment)
        commentRepository.save(commentEntity)
    }

    @Transactional
    override fun updateComment(commentId: UUID, request: UpdateCommentDomainRequest) {
        val comment = findById(commentId)
        val commentEntity = commentMapper.commentDomainToEntity(comment)
        commentEntity.updateComment(request.content)
    }


    private fun findById(commentId: UUID): Comment {
        val commentEntity = jpaCommentById(commentId)
        return commentMapper.commentEntityToDomain(commentEntity)
    }


    private fun jpaCommentById(id: UUID) =
        commentRepository.findByIdOrNull(id) ?: throw CommentNotFoundException
}