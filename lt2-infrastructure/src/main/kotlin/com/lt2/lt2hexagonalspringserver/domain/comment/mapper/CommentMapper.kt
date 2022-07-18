package com.lt2.lt2hexagonalspringserver.domain.comment.mapper

import com.lt2.lt2hexagonalspringserver.comment.Comment
import com.lt2.lt2hexagonalspringserver.domain.comment.domain.CommentEntity

interface CommentMapper {
    fun commentDomainToEntity(comment: Comment): CommentEntity
    fun commentEntityToDomain(commentEntity: CommentEntity): Comment
}