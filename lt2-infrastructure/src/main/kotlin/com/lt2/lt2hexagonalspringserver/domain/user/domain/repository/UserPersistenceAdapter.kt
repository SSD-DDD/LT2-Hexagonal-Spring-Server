package com.lt2.lt2hexagonalspringserver.domain.user.domain.repository

import com.lt2.lt2hexagonalspringserver.domain.user.mapper.UserMapper
import com.lt2.lt2hexagonalspringserver.global.annotation.Adapter
import org.springframework.security.crypto.password.PasswordEncoder
import user.User
import user.exception.UserAlreadyExistsException
import user.exception.UserNotFoundException
import user.spi.UserPasswordSpi
import user.spi.UserRepositorySpi

@Adapter
class UserPersistenceAdapter(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper,
    private val passwordEncoder: PasswordEncoder
): UserRepositorySpi, UserPasswordSpi {

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

    override fun passwordEncode(password: String): String = passwordEncoder.encode(password)

    override fun passwordMatch(rawPassword: String, encodedPassword: String) =
        passwordEncoder.matches(rawPassword, encodedPassword)

    fun jpaUserByAccountId(accountId: String) =
        userRepository.findByAccountId(accountId) ?: throw UserNotFoundException
}