package com.lt2.lt2hexagonalspringserver.domain.user.domain.repository

import com.lt2.lt2hexagonalspringserver.domain.user.domain.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserRepository: CrudRepository<UserEntity, UUID> {
    
}