package com.lt2.lt2hexagonalspringserver.domain.user.domain.repository

import com.lt2.lt2hexagonalspringserver.domain.user.mapper.UserMapper
import com.lt2.lt2hexagonalspringserver.global.annotation.Adapter
import com.lt2.lt2hexagonalspringserver.user.User
import com.lt2.lt2hexagonalspringserver.user.exception.UserAlreadyExistsException
import com.lt2.lt2hexagonalspringserver.user.exception.UserNotFoundException
import com.lt2.lt2hexagonalspringserver.user.spi.UserSpi
import org.springframework.security.core.context.SecurityContextHolder

@Adapter
class UserPersistenceAdapter(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
): UserSpi {

    override fun saveUser(user: User) {
        val userEntity = userMapper.userDomainToEntity(user)
        userRepository.save(userEntity)
    }

    override fun checkUserExistsByAccountId(accountId: String) {
        userRepository.findByAccountId(accountId)?.let {
            throw UserAlreadyExistsException
        }
    }

    override fun findByAccountId(accountId: String): User {
        val userEntity = jpaUserByAccountId(accountId)
        return userMapper.userEntityToDomain(userEntity)
    }

    override fun currentUser(): User {
        val accountId = SecurityContextHolder.getContext().authentication.name
        return findByAccountId(accountId)
    }

    fun jpaUserByAccountId(accountId: String) =
        userRepository.findByAccountId(accountId) ?: throw UserNotFoundException
}