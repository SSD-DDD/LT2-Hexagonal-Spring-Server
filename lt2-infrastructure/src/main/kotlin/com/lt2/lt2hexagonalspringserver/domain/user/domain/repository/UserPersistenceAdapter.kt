package com.lt2.lt2hexagonalspringserver.domain.user.domain.repository

import com.lt2.lt2hexagonalspringserver.domain.user.mapper.UserMapper
import com.lt2.lt2hexagonalspringserver.global.annotation.Adapter
import com.lt2.lt2hexagonalspringserver.user.User
import com.lt2.lt2hexagonalspringserver.user.exception.UserAlreadyExistsException
import com.lt2.lt2hexagonalspringserver.user.exception.UserNotFoundException
import com.lt2.lt2hexagonalspringserver.user.spi.QueryUserSpi
import com.lt2.lt2hexagonalspringserver.user.spi.UserSpi

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

    fun jpaUserByAccountId(accountId: String) =
        userRepository.findByAccountId(accountId) ?: throw UserNotFoundException
}