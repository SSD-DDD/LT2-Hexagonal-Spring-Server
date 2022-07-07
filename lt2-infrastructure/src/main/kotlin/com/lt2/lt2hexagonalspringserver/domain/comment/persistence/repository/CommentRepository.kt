package com.lt2.lt2hexagonalspringserver.domain.comment.persistence.repository

import com.lt2.lt2hexagonalspringserver.domain.comment.persistence.entity.CommentEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CommentRepository: CrudRepository<CommentEntity, UUID> {
}