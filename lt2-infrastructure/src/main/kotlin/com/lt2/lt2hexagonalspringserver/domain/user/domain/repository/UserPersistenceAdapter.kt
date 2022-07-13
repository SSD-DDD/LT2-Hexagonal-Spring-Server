package com.lt2.lt2hexagonalspringserver.domain.user.domain.repository

import com.lt2.lt2hexagonalspringserver.domain.user.mapper.UserMapper
import com.lt2.lt2hexagonalspringserver.global.annotation.Adapter
import user.User
import user.exception.UserAlreadyExistsException
import user.exception.UserNotFoundException
import user.spi.UserSpi

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
        val userEntity = userRepository.findByAccountId(accountId) ?: throw UserNotFoundException
        return userMapper.userEntityToDomain(userEntity)
    }

    fun jpaUserByAccountId(accountId: String) =
        userRepository.findByAccountId(accountId) ?: throw UserNotFoundException
}