package com.lt2.lt2hexagonalspringserver.domain.comment.domain.repository

import com.lt2.lt2hexagonalspringserver.domain.comment.domain.CommentEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CommentRepository: CrudRepository<CommentEntity, UUID> {
}